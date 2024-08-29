package com.snowflake.testutils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    /**
     * Main method to generate PDFs with random text
     * If no argument is provided, 10000 PDFs will be generated, otherwise the number of PDFs to generate is provided as an argument.
     * Files are generated under the folder "filesGenerated" in the project root.
     *
     * @param args
     */
    public static void main(String[] args) {
        int defaultNumberOfPDFsToGenerate = 10000;
        int numberOfPDFsToGenerate = defaultNumberOfPDFsToGenerate;
        if (args.length > 0) {
            try {
                numberOfPDFsToGenerate = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Using default number of PDFs to generate: " + defaultNumberOfPDFsToGenerate);
            }
        }
        File targetFolder = new File("filesGenerated");
        if (!targetFolder.exists()) {
            targetFolder.mkdir();
        }

        long time = System.currentTimeMillis();
        for (int i = 0; i < numberOfPDFsToGenerate; i++) {
            createRandomPDF();
        }
        time = System.currentTimeMillis() - time;
        System.out.println("Time: " + time);
    }

    public static void createPDF(String text, String fileName) throws IOException {
        PDDocument doc = new PDDocument();
        PDPage page = new PDPage();
        doc.addPage(page);
        PDPageContentStream content = new PDPageContentStream(doc, page);
        content.beginText();
        content.newLineAtOffset(25, 700);
        content.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN), 16);
        content.showText(text);
        content.endText();
        content.close();
        doc.save(fileName);
        doc.close();
    }

    private static String buildRandomText() {
        List<Integer> years = new ArrayList<>();
        for (int i = 1920; i < 2025; i++) {
            years.add(i);
        }
        List<String> colors = new ArrayList<>();
        colors.add("red");
        colors.add("blue");
        colors.add("green");
        colors.add("yellow");
        colors.add("black");
        colors.add("white");
        int randomProductionCount = (int) (Math.random() * 10000000) + 1;
        int randomYear = years.get((int) (Math.random() * years.size()));
        String randomColor = colors.get((int) (Math.random() * colors.size()));
        return "In the year " + randomYear + " we produced " + randomProductionCount + " " + randomColor + " cars.";
    }

    public static void createRandomPDF() {
        long randInt = (long) (Math.random() * System.currentTimeMillis());
        String fileName = "filesGenerated/" + randInt + "_test.pdf";
        try {
            createPDF(buildRandomText(), fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
