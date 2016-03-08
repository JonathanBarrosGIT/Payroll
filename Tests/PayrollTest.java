import EmployeePackage.CommissionedEmployee;
import EmployeePackage.Employee;
import EmployeePackage.HourlyEmployee;
import EmployeePackage.SalariedEmployee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by JonathanBarros on 3/8/16.
 *
 */
public class PayrollTest {

    Payroll payroll = new Payroll();

    @Before
    public void setUp() throws Exception {
        //System.out.println("Setting up!");
    }

    @Test
    public void testAddEmployee() throws Exception {
        Employee employee = new HourlyEmployee("Jonathan", "Rua A", 10);
        //Employee employee1 = new CommissionedEmployee("Jonathan", "Rua B", 1000, 10);
        //Employee employee2 = new SalariedEmployee("Jonathan", "Rua C", 1000);
        payroll.addEmployee(employee);
        //assertEquals(employee.getAddress(),"Rua A");
    }

    @Test
    public void testRemoveEmployee() throws Exception {

    }

    @Test
    public void testRegisterTimeCard() throws Exception {

    }

    @Test
    public void testRegisterSaleResult() throws Exception {

    }

    @Test
    public void testRegisterServiceFee() throws Exception {

    }

    @Test
    public void testChangeEmployeeName() throws Exception {

    }

    @Test
    public void testChangeEmployeeAddress() throws Exception {

    }

    @Test
    public void testChangeLaborUnionSubscription() throws Exception {

    }

    @Test
    public void testSameLaborUnionId() throws Exception {

    }

    @Test
    public void testChangeLaborUnionID() throws Exception {

    }

    @Test
    public void testChangeLaborUnionFee() throws Exception {

    }

    @Test
    public void testChangePaymentMethod() throws Exception {

    }

    @Test
    public void testChangeToHourlyEmployee() throws Exception {

    }

    @Test
    public void testChangeToSalariedEmployee() throws Exception {

    }

    @Test
    public void testChangeToCommissionedEmployee() throws Exception {

    }

    @Test
    public void testChangeEmployeeType() throws Exception {

    }

    /*@Test
    public void testCreateNewPaymentSchedule() throws Exception {

    }*/

    @After
    public void tearDown() throws Exception {

    }
}