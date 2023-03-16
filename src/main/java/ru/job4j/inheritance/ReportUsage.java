package ru.job4j.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        HtmlReport reportHtml = new HtmlReport();
        JSONReport reportJson = new JSONReport();
        TextReport report = new TextReport();
        String text = report.generate("Report's name", "Report's body");
        System.out.println(text);
        text = reportHtml.generate("Report's name", "Report's body");
        System.out.println(text);
        text = reportJson.generate("Report's name", "Report's body");
        System.out.println(text);
    }
}
