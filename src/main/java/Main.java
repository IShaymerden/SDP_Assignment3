import bridge.*;

public class Main {

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("--demo")) {
            runDemo();
        } else {
            System.out.println("Run with --demo");
        }
    }

    private static void runDemo() {
        int passed = 0;
        int total = 7;

        String message = "Assignment deadline tomorrow";

        // T1
        Reminder t1 = new Reminder("R1", message, new EmailChannel());
        String actual1 = t1.execute();
        String expected1 = "EMAIL envelope: Assignment deadline tomorrow";

        if (printResult("T1", "Reminder + EmailChannel", actual1, expected1)) {
            passed++;
        }

        // T2
        Reminder t2 = new Reminder("R2", message, new SmsChannel());
        String actual2 = t2.execute();
        String expected2 = "SMS: Assignment deadline tomorrow";

        if (printResult("T2", "Reminder + SmsChannel", actual2, expected2)) {
            passed++;
        }

        // T3
        UrgentAlert t3 = new UrgentAlert(
                "U1",
                "Server is down",
                new EmailChannel()
        );

        String actual3 = t3.execute();
        String expected3 = "EMAIL envelope: URGENT: Server is down";

        if (printResult("T3", "UrgentAlert + EmailChannel", actual3, expected3)) {
            passed++;
        }

        // T4
        UrgentAlert t4 = new UrgentAlert(
                "U2",
                "Server is down",
                new SmsChannel()
        );

        String actual4 = t4.execute();
        String expected4 = "SMS: URGENT: Server is down";

        if (printResult("T4", "UrgentAlert + SmsChannel", actual4, expected4)) {
            passed++;
        }

        // T5 - runtime implementation switch
        Reminder t5 = new Reminder(
                "R5",
                message,
                new EmailChannel()
        );

        Reminder originalReference = t5;

        String oldId = t5.getId();
        String oldMessage = t5.getMessage();

        String before = t5.execute();

        t5.setImplementation(new SmsChannel());

        String after = t5.execute();

        boolean sameObject = originalReference == t5;

        boolean stateUnchanged =
                oldId.equals(t5.getId()) &&
                        oldMessage.equals(t5.getMessage());

        boolean t5Pass =
                sameObject &&
                        stateUnchanged &&
                        before.equals("EMAIL envelope: Assignment deadline tomorrow") &&
                        after.equals("SMS: Assignment deadline tomorrow");

        System.out.println(
                "T5 " + (t5Pass ? "PASS" : "FAIL") +
                        " | sameObject=" + sameObject +
                        " | stateUnchanged=" + stateUnchanged
        );

        System.out.println(" before=" + before);
        System.out.println(" after=" + after);

        if (t5Pass) {
            passed++;
        }

        // T6
        Reminder t6 = new Reminder(
                "R6",
                message,
                new PushChannel()
        );

        String actual6 = t6.execute();
        String expected6 =
                "PUSH notification: Assignment deadline tomorrow";

        if (printResult("T6", "Reminder + PushChannel", actual6, expected6)) {
            passed++;
        }

        // T7
        UrgentAlert t7 = new UrgentAlert(
                "U7",
                "Server is down",
                new PushChannel()
        );

        String actual7 = t7.execute();
        String expected7 =
                "PUSH notification: URGENT: Server is down";

        if (printResult("T7", "UrgentAlert + PushChannel", actual7, expected7)) {
            passed++;
        }

        System.out.println();
        System.out.println("SUMMARY: " + passed + "/" + total + " PASS");
    }

    private static boolean printResult(
            String testId,
            String classes,
            String actual,
            String expected
    ) {
        boolean passed = actual.equals(expected);

        System.out.println(
                testId + " " + (passed ? "PASS" : "FAIL") +
                        " | " + classes +
                        " | result=" + actual
        );

        if (!passed) {
            System.out.println(" expected=" + expected);
        }

        return passed;
    }
}