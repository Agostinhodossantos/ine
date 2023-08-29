package user.panel.portlet;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.ParamUtil;
import user.panel.constants.UserPanelPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.util.List;

import static user.panel.util.Util.*;

/**
 * @author HP
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=UserPanel",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + UserPanelPortletKeys.USERPANEL,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class UserPanelPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		renderRequest.setAttribute("users", getUsers());
		super.render(renderRequest, renderResponse);
	}

	@ProcessAction(name = "viewBook")
	public void viewBook(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String bookId = actionRequest.getParameter("bookId");
		User user = getUserById(Long.parseLong(bookId));

		actionRequest.setAttribute("current", user);
		actionResponse.setRenderParameter("jspPage", "/biography.jsp");
	}

	@ProcessAction(name = "searchUsers")
	public void searchUsers(ActionRequest actionRequest, ActionResponse actionResponse) {
		String searchQuery = ParamUtil.getString(actionRequest, "search");

		System.out.println("searchUsers: " + searchQuery);

		List<User> users = searchUserByName(searchQuery);


		if (users != null) {
			System.out.println("searchUsers: " + users);
			actionRequest.setAttribute("searchUsers", users);
			actionResponse.setRenderParameter("jspPage", "/search_result.jsp");
		}

	}

}