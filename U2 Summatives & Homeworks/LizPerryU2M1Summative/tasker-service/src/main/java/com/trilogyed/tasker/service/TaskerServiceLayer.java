package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.exception.NotFoundException;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdServerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskerServiceLayer {

    @Autowired
    TaskerDao taskerDao;

    @Autowired
    private final AdServerClient client;

    @Autowired
    TaskerServiceLayer(AdServerClient client, TaskerDao taskerDao) {
        this.client = client;
        this.taskerDao = taskerDao;
    }

    public TaskViewModel fetchTask(int id) {

        Task task = taskerDao.getTask(id);
        TaskViewModel tvm = new TaskViewModel();

        if (task == null)
            throw new NotFoundException("Could not find task by id " + id);
        else {
            tvm.setId(task.getId());
            tvm.setDescription(task.getDescription());
            tvm.setCreateDate(task.getCreateDate());
            tvm.setDueDate(task.getDueDate());
            tvm.setCategory(task.getCategory());
            tvm.setAdvertisement(client.getAd());
        }
        // TODO - get ad from Adserver and put in tvm

        return tvm;
    }

    public List<TaskViewModel> fetchAllTasks() {

        List<Task> tL = taskerDao.getAllTasks();
        List<TaskViewModel> tvmL = new ArrayList<>();

        if (tL != null && tL.size() == 0)
            throw new NotFoundException("Tasks could not be retrieved.");
        else {
            for (Task task: tL) {
                tvmL.add(buildTaskViewModel(task));
            }
        }
        return tvmL;
    }

    public List<TaskViewModel> fetchTasksByCategory(String category) {

        List <Task> tL = taskerDao.getTasksByCategory(category);
        List<TaskViewModel> tvmL = new ArrayList<>();

        if (tL != null && tL.size() == 0)
            throw new NotFoundException("Tasks could not be retrieved");
        else {
            for (Task task : tL) {
                tvmL.add(buildTaskViewModel(task));
            }
        }

        return tvmL;
    }

    @Transactional
    public TaskViewModel newTask(TaskViewModel taskViewModel) {

        Task task = new Task();

        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());

        taskerDao.createTask(task);

        taskViewModel.setId(task.getId());

        taskViewModel.setAdvertisement(client.getAd());

        // TODO - get ad from Adserver and put in taskViewModel
        return taskViewModel;
    }

    public void deleteTask(int id) {

        taskerDao.deleteTask(id);

    }

    @Transactional
    public void updateTask(TaskViewModel taskViewModel) {

        Task task = new Task();

        task.setId(taskViewModel.getId());
        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());

        taskerDao.updateTask(task);
    }

    //Helper
    private TaskViewModel buildTaskViewModel (Task task) {

        TaskViewModel taskViewModel = new TaskViewModel();

        taskViewModel.setId(task.getId());
        taskViewModel.setDescription(task.getDescription());
        taskViewModel.setCreateDate(task.getCreateDate());
        taskViewModel.setDueDate(task.getDueDate());
        taskViewModel.setCategory(task.getCategory());
        taskViewModel.setAdvertisement(client.getAd());

        return taskViewModel;
    }
}
