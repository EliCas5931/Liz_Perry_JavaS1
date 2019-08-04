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
    protected TaskerDao taskerDao;

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










}
