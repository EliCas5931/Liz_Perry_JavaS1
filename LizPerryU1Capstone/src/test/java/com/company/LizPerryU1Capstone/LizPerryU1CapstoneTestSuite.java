package com.company.LizPerryU1Capstone;

import com.company.LizPerryU1Capstone.dao.ConsoleDaoJdbcTemplateImplTest;
import com.company.LizPerryU1Capstone.dao.GameDaoJdbcTemplateImplTest;
import com.company.LizPerryU1Capstone.dao.TShirtDaoJdbcTemplateImplTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({

        ConsoleDaoJdbcTemplateImplTest.class,
        GameDaoJdbcTemplateImplTest.class,
        TShirtDaoJdbcTemplateImplTest.class
})

public class LizPerryU1CapstoneTestSuite {
}
