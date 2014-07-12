package com.xebia.pricer.junit.dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ProductDaoTest.class, StorePriceDaoTest.class })
public class AllDaoTests {

}
