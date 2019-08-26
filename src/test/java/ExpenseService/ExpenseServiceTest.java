package ExpenseService;

import ExpenseService.Exception.UnexpectedProjectTypeException;
import ExpenseService.Expense.ExpenseType;
import ExpenseService.Project.Project;
import ExpenseService.Project.ProjectType;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.oocl.cultivation.ParkingLot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class ExpenseServiceTest {
    @Test
    void should_return_internal_expense_type_if_project_is_internal() throws UnexpectedProjectTypeException {
        // given
    	String projectName=null;
    	ExpenseType returnType;
    	Project project = new Project(ProjectType.INTERNAL,projectName);

        // when
    	returnType=ExpenseService.getExpenseCodeByProjectTypeAndName(project);
        // then
    	assertEquals(ExpenseType.INTERNAL_PROJECT_EXPENSE,returnType);
    	
    }

    @Test
    void should_return_expense_type_A_if_project_is_external_and_name_is_project_A() throws UnexpectedProjectTypeException {
        // given
    	ExpenseType returnType;
    	Project project = new Project(ProjectType.EXTERNAL,"Project A");
        // when
    	returnType=ExpenseService.getExpenseCodeByProjectTypeAndName(project);
        // then
    	assertEquals(ExpenseType.EXPENSE_TYPE_A,returnType);
    }

    @Test
    void should_return_expense_type_B_if_project_is_external_and_name_is_project_B() throws UnexpectedProjectTypeException {
    	// given
    	ExpenseType returnType;
    	Project project = new Project(ProjectType.EXTERNAL,"Project B");
        // when
    	returnType=ExpenseService.getExpenseCodeByProjectTypeAndName(project);
        // then
    	assertEquals(ExpenseType.EXPENSE_TYPE_B,returnType);
    }

    @Test
    void should_return_other_expense_type_if_project_is_external_and_has_other_name() throws UnexpectedProjectTypeException {
    	// given
    	String projectName="zyProject";
    	ExpenseType returnType;
    	Project project = new Project(ProjectType.EXTERNAL,projectName);
        // when
    	returnType=ExpenseService.getExpenseCodeByProjectTypeAndName(project);
        // then
    	assertEquals(ExpenseType.OTHER_EXPENSE,returnType);
    }

    @Test
    void should_throw_unexpected_project_exception_if_project_is_invalid() {
        // given
    	Project project = new Project(ProjectType.EXTERNAL,"Project B");
        // when
        // then
    }
}