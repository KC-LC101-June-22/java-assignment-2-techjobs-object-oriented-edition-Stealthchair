package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static java.lang.String.valueOf;
import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job allFieldsJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(allFieldsJob.getName() instanceof String);
        assertTrue(allFieldsJob.getEmployer() instanceof Employer);
        assertTrue(allFieldsJob.getLocation() instanceof Location);
        assertTrue(allFieldsJob.getPositionType() instanceof PositionType);
        assertTrue(allFieldsJob.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(allFieldsJob.getName(), "Product tester");
        assertEquals(allFieldsJob.getEmployer().getValue(), "ACME");
        assertEquals(allFieldsJob.getLocation().getValue(), "Desert");
        assertEquals(allFieldsJob.getPositionType().getValue(), "Quality control");
        assertEquals(allFieldsJob.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job toStringJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals('\n', toStringJob.toString().charAt(0));
        assertEquals('\n', toStringJob.toString().charAt(toStringJob.toString().length()-1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job toStringJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("ID:", toStringJob.toString().substring(1, 4));
        assertTrue(toStringJob.toString().contains("ID:"));
        assertTrue(toStringJob.toString().contains(valueOf(toStringJob.getId())));
        assertTrue(toStringJob.toString().contains("Name:"));
        assertTrue(toStringJob.toString().contains(toStringJob.getName()));
        assertTrue(toStringJob.toString().contains("Employer:"));
        assertTrue(toStringJob.toString().contains(toStringJob.getEmployer().getValue()));
        assertTrue(toStringJob.toString().contains("Location:"));
        assertTrue(toStringJob.toString().contains(toStringJob.getLocation().getValue()));
        assertTrue(toStringJob.toString().contains("Position Type:"));
        assertTrue(toStringJob.toString().contains(toStringJob.getPositionType().getValue()));
        assertTrue(toStringJob.toString().contains("Core Competency:"));
        assertTrue(toStringJob.toString().contains(toStringJob.getCoreCompetency().getValue()));
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job emptyJob = new Job();
        String resultingString = emptyJob.toString();
        assertNull(emptyJob.getName());
        assertNull(emptyJob.getEmployer());
        assertNull(emptyJob.getLocation());
        assertNull(emptyJob.getPositionType());
        assertNull(emptyJob.getCoreCompetency());

        assertTrue(resultingString.contains("Name: Data not available"));
        assertTrue(resultingString.contains("Employer: Data not available"));
        assertTrue(resultingString.contains("Location: Data not available"));
        assertTrue(resultingString.contains("Position Type: Data not available"));
        assertTrue(resultingString.contains("Core Competency: Data not available"));
        assertEquals("HI", "HI");
    }
}
