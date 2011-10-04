/*
 * The MIT License
 *
 * Copyright (c) <2010> <Bruno P. Kinoshita>
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.eti.kinoshita.testlinkjavaapi.testsuite;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import br.eti.kinoshita.testlinkjavaapi.BaseTest;
import br.eti.kinoshita.testlinkjavaapi.TestLinkAPIException;
import br.eti.kinoshita.testlinkjavaapi.model.TestSuite;

/**
 * @author Bruno P. Kinoshita - http://www.kinoshita.eti.br
 * @since 
 */
public class TestGetTestSuiteById 
extends BaseTest
{
	
	@DataProvider(name="validTestSuite")
	public Object[][] createData()
	{
		return new Object[][] 
        {
			{
				2
			}, 
			{
				3
			}
        };
	}

	@Test(dataProvider="validTestSuite")
	public void testGetTestSuiteById(Integer suiteId)
	{
		this.loadXMLRPCMockData("tl.getTestSuiteByID.xml");
		
		TestSuite[] testSuites = null;
		
		List<Integer> testSuiteIds = new ArrayList<Integer>();
		testSuiteIds.add( suiteId );
		
		try
		{
			testSuites = api.getTestSuiteByID( testSuiteIds );
		} 
		catch (TestLinkAPIException e)
		{
			Assert.fail(e.getMessage(), e);
		}
		
		Assert.assertNotNull( testSuites );
		
		Assert.assertTrue( testSuites.length == 1 );
	}
	
}
