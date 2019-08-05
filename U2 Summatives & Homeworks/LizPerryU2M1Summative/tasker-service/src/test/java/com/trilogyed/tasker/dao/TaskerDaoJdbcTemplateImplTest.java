package com.trilogyed.tasker.dao;

import com.trilogyed.tasker.model.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskerDaoJdbcTemplateImplTest {

    @Autowired
    TaskerDao taskerDao;

    @Before
    public void setUp() throws Exception {

        List<Task> tL = taskerDao.getAllTasks();

        for (Task t : tL) {
            taskerDao.deleteTask(t.getId());
        }
    }

    @Test
    public void addGetDelete() {

        Task task = new Task();

        task.setDescription("Homework Task");
        task.setCreateDate(LocalDate.of(2018, 02, 01));
        task.setDueDate(LocalDate.of(2018, 02, 14));
        task.setCategory("School Work");

        task = taskerDao.createTask(task);

        Task task2 = taskerDao.getTask(task.getId());
        assertEquals(task2, task);

        taskerDao.deleteTask(task.getId());
        task2 = taskerDao.getTask(task.getId());
        assertNull(task2);
    }

    @Test
    public void getAllTasks() {
        Task task = new Task();

        task.setDescription("Homework Task");
        task.setCreateDate(LocalDate.of(2018, 02, 01));
        task.setDueDate(LocalDate.of(2018, 02, 14));
        task.setCategory("School Work");

        task = taskerDao.createTask(task);

        Task task2 = new Task();

        task2.setDescription("Second Homework Task");
        task2.setCreateDate(LocalDate.of(2018, 04, 15));
        task2.setDueDate(LocalDate.of(2018, 04, 19));
        task2.setCategory("School Work");

        taskerDao.createTask(task2);

        Task task3 = new Task();

        task3.setDescription("Finish Work Report Task");
        task3.setCreateDate(LocalDate.of(2018, 07, 01));
        task3.setDueDate(LocalDate.of(2018, 07, 04));
        task3.setCategory("Job Stuff ");

        taskerDao.createTask(task3);

        List<Task> tL = taskerDao.getAllTasks();
        assertEquals(tL.size(), 3);
    }

    @Test
    public void updateTask() {

        Task task = new Task();

        task.setDescription("Homework Task");
        task.setCreateDate(LocalDate.of(2018, 02, 01));
        task.setDueDate(LocalDate.of(2018, 02, 14));
        task.setCategory("School Work");

        task = taskerDao.createTask(task);

        task.setDescription("Work Task");
        task.setCreateDate(LocalDate.of(2019, 03, 02));
        task.setDueDate(LocalDate.of(2019, 03, 15));
        task.setCategory("Work Stuff");

        taskerDao.updateTask(task);

        Task task2 = taskerDao.getTask(task.getId());

        assertEquals(task2, task);
    }

    @Test
    public void getTasksByCategory() {

        Task task = new Task();

        task.setDescription("Homework Task");
        task.setCreateDate(LocalDate.of(2018, 02, 01));
        task.setDueDate(LocalDate.of(2018, 02, 14));
        task.setCategory("School Work");

        task = taskerDao.createTask(task);

        Task task2 = new Task();

        task2.setDescription("Second Homework Task");
        task2.setCreateDate(LocalDate.of(2018, 04, 15));
        task2.setDueDate(LocalDate.of(2018, 04, 19));
        task2.setCategory("School Work");

        taskerDao.createTask(task2);

        Task task3 = new Task();

        task3.setDescription("Finish Work Report Task");
        task3.setCreateDate(LocalDate.of(2018, 07, 01));
        task3.setDueDate(LocalDate.of(2018, 07, 04));
        task3.setCategory("Job Stuff ");

        taskerDao.createTask(task3);

        List<Task> tL = taskerDao.getTasksByCategory("School Work");
        assertEquals(tL.size(), 2);
    }










}
