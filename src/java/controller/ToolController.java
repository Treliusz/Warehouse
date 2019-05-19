package controller;

import service.ToolsService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Long.valueOf;

@WebServlet (name = "ToolList", value = "/")
public class ToolController extends HttpServlet {

    private static final String TOOL_VAR_NAME = "tools";

    private ToolsService toolService = new ToolsService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        initializeTools();

        String action = req.getParameter("action");

        if (action != null) {
            processAction(action, valueOf(req.getParameter("id")));
        }

        req.getRequestDispatcher("/start.jsp").forward(req, resp);
    }

    private void processAction(String action, Long toolId) {
        switch (action) {
            case "take":
                toolService.takeTool(toolId);
                break;
            case "return":
                toolService.returnTool(toolId);
                break;
        }
    }

    private void initializeTools() {
        if (getServletContext().getAttribute(TOOL_VAR_NAME) == null) {
            getServletContext().setAttribute(TOOL_VAR_NAME, toolService.getTools());
        }
    }
}
