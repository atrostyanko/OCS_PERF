package tests.request;

import com.reporting.ExtentManager;
import pages.request.AddRequestPage;
import pages.request.EditRequestPage;
import pages.request.RequestDetailsPage;
import pages.request.ViewAllRequestsPage;

import java.util.Properties;

public class RequestTests {
    private ExtentManager eReports;
    private Properties prop;

    public RequestTests(ExtentManager eReports, Properties prop) {
        this.eReports = eReports;
        this.prop = prop;
    }

    public void RequestDetails_BVT() {
        String corrID = prop.getProperty("requestDetailsPage_corrID");

        eReports.createNode("REQUEST -> Request Details page.", "Verify the Request Details page.");

        RequestDetailsPage requestDetailsPage = new RequestDetailsPage();
        if (eReports.compareNotNULL(requestDetailsPage, "Open 'REQUEST -> Request Details' page.")) {

            eReports.compareTrue(requestDetailsPage.corrId.setText(corrID),
                    "Set Corr ID to " + corrID);
            eReports.compareTrue(requestDetailsPage.clickSubmit(),
                    "Click 'Submit' button and verify that Request Details are displayed.");
        }
    }

    public void EditRequest_BVT() {
        String corrID = prop.getProperty("editRequestPage_corrID");

        eReports.createNode("REQUEST -> Edit Request page.", "Verify the Edit Request page.");

        EditRequestPage editRequestPage = new EditRequestPage();
        if (eReports.compareNotNULL(editRequestPage, "Open 'REQUEST -> Edit Request' page.")) {

            eReports.compareTrue(editRequestPage.corrId.setText(corrID),
                    "Set Corr ID to " + corrID);
            eReports.compareTrue(editRequestPage.clickSubmit(),
                    "Click 'Submit' button and verify that Edit Request Details page is is displayed.");
        }
    }

    public void AddRequest_BVT() {
        eReports.createNode("REQUEST -> Add Request page.", "Verify the Add Request page.");

        AddRequestPage addRequestPage = new AddRequestPage();
        eReports.compareNotNULL(addRequestPage, "Open 'REQUEST -> Add Request' page.");
    }

    public void ViewAllRequests_BVT() {
        String corrID = prop.getProperty("editRequestPage_corrID");

        eReports.createNode("REQUEST -> View All Requests page.", "Verify the View All Requests page.");

        ViewAllRequestsPage viewAllRequestsPage = new ViewAllRequestsPage();
        if (eReports.compareNotNULL(viewAllRequestsPage, "Open 'REQUEST -> View All Requests' page.")) {

            eReports.compareTrue(viewAllRequestsPage.corrId.setText(corrID),
                    "Set Corr ID to " + corrID);
            eReports.compareTrue(viewAllRequestsPage.clickSubmit(),
                    "Click 'Submit' button and verify that Edit Request Details page is is displayed.");
        }
    }
}
