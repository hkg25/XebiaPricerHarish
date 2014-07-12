package com.xebia.pricer.junit.dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.xebia.pricer.junit.facade.IdealPriceCalculatorTest;

@RunWith(Suite.class)
@SuiteClasses({ ProductDaoTest.class, StorePriceDaoTest.class, IdealPriceCalculatorTest.class })
public class AllDaoTests {

}
