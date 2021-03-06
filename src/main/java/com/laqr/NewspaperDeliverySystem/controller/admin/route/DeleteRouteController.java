package com.laqr.NewspaperDeliverySystem.controller.admin.route;

import com.laqr.NewspaperDeliverySystem.services.RouteService;
import com.laqr.NewspaperDeliverySystem.services.UserService;
import com.laqr.NewspaperDeliverySystem.util.UserUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class DeleteRouteController {

    final RouteService routeService;
    final UserService userService;
    final UserUtils userUtils;

    public DeleteRouteController(RouteService routeService, UserService userService, UserUtils userUtils) {
        this.routeService = routeService;
        this.userService = userService;
        this.userUtils = userUtils;
    }

    @PostMapping("/delete-route")
    public String deleteRoute(
            RedirectAttributes redirectAttributes,
            HttpSession session,
            @RequestParam("route-id") Integer routeID
    ) {
        if (userUtils.isValidAdmin(session, userService, null)) {
            routeService.deleteRoute(routeID);
            redirectAttributes.addFlashAttribute("success", "Successfully Deleted Route");

            return "redirect:/admin/view-route";
        } else
            return "redirect:/";
    }
}
