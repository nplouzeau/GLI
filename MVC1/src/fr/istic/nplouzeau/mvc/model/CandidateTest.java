package fr.istic.nplouzeau.mvc.model;


import org.junit.Assert;
import org.junit.Test;

public class CandidateTest {

    Candidate.CandidateBuilder testBuilder;

    @org.junit.Before
    public void setUp() throws Exception {
        testBuilder = Candidate.GetBuilder();

    }

    @org.junit.Test
    public void testGetBuilder() throws Exception {
        Assert.assertNotNull(testBuilder);
    }

    @org.junit.Test
    public void testGetName() throws Exception {
        testBuilder.name("Haddock");
        Assert.assertEquals("Haddock",testBuilder.build().getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullName() throws Exception {
        testBuilder.name(null);
        testBuilder.build();

    }

    @org.junit.Test
    public void testGetEmailAddress() throws Exception {
        final String testAddress =  "archibald@moulinsart.be";
        testBuilder.name("Haddock");
        testBuilder.emailAddress(testAddress);
        Assert.assertEquals(testAddress,testBuilder.build().getEmailAddress());
    }
}