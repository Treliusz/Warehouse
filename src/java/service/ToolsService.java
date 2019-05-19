package service;

import dao.ToolDao;
import dao.ToolDaoImpl;
import model.Tool;
import model.ToolType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



public class ToolsService {

    private ToolDao toolDao = new ToolDaoImpl();

    public List<Tool> getTools(){
        return toolDao.getAllTools();
    }

    public Optional<Tool> getTool(Long id){
        return toolDao.getAllTools().stream().filter(tool -> tool.getId().equals(id)).findAny();
    }

    public void takeTool(Long id){
        setAvailability(id, false);
    }

    public void returnTool(Long id){
        setAvailability(id, true);
    }

    private List<Tool> setAvailability(Long id, boolean isAvailable){
        toolDao.setAvailability(id, isAvailable);

        return getTools();
    }
}