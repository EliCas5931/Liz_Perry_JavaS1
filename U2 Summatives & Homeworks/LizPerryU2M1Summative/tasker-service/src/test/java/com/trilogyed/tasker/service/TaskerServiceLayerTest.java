package com.trilogyed.tasker.service;


import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.dao.TaskerDaoJdbcTemplateImpl;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdServerClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class TaskerServiceLayerTest {

    private TaskerDao taskerDao;
    AdServerClient client;
    TaskerServiceLayer service;

    @Before
    public void setUp() throws Exception {
        setUpAdServerClient();
        setUpTaskerDaoMock();
        service = new TaskerServiceLayer(client, taskerDao);
    }

    public void setUpAdServerClient() {
        client = mock(AdServerClient.class);
        doReturn("And now a message from our sponsors: ").when(client).getAd();
    }

    private void setUpTaskerDaoMock() {
        taskerDao = mock(TaskerDaoJdbcTemplateImpl.class);

        Task task = new Task();

        task.setId(5);
        task.setDescription("Finish your summative!");
        task.setCreateDate(LocalDate.of(2019, 07, 01));
        task.setDueDate(LocalDate.of(2019, 07, 14));
        task.setCategory("School Work");

        Task task2 = new Task();

        task2.setDescription("Finish reading chapter 7");
        task2.setCreateDate(LocalDate.of(2019, 06, 06));
        task2.setDueDate(LocalDate.of(2019, 06, 11));
        task2.setCategory("School Work");

        List<Task> tL = new ArrayList<>();
        tL.add(task);

        doReturn(task).when(taskerDao).createTask(task2);
        doReturn(task).when(taskerDao).getTask(5);
        doReturn(tL).when(taskerDao).getAllTasks();
        doReturn(tL).when(taskerDao).getTasksByCategory("School Work");
    }

    @Test
    public void newTask() {
        TaskViewModel tvm = new TaskViewModel();

        tvm.setDescription("Finish your summative!");
        tvm.setCreateDate(LocalDate.of(2019, 07, 01));
        tvm.setDueDate(LocalDate.of(2019, 07, 14));
        tvm.setCategory("School Work");
        tvm.setAdvertisement(client.getAd());

        TaskViewModel fromService = service.newTask(tvm);

        tvm.setId(fromService.getId());

        assertEquals(tvm, fromService);
    }

    @Test
    public void fetchTask() {
        TaskViewModel fromService = service.fetchTask(5);

        fromService.setAdvertisement(client.getAd());

        assertEquals(taskerDao.getTask(5).getDescription(), fromService.getDescription());
    }

    @Test
    public void fetchAllTasks(){
        List<TaskViewModel> tvmList = service.fetchAllTasks();

        assertEquals(tvmList.size(), 1);

        assertEquals(tvmList.get(0).getId(), 5);
    }

    @Test
    public void fetchTasksByCategory(){
        List<TaskViewModel> tvmList = service.fetchTasksByCategory("School Work");

        assertEquals(tvmList.size(), 1);

        assertEquals(tvmList.get(0).getCategory(), "School Work");
    }

}
