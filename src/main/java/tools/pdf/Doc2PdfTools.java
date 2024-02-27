package tools.pdf;

import com.spire.doc.CssStyleSheetType;
import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import com.spire.doc.ToPdfParameterList;
import com.spire.doc.documents.ImageType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Doc2PdfTools {

    public static void main(String[] args) {
        conver();
    }

    private static void conver() {
        //Create a Document instance
        Document doc = new Document(false);
        //Load a sample Word document
        doc.loadFromFile("/Users/luzhk/Project/gp-report/report/intime/cb0300pdf-wr.docx");
        //Create a ToPdfParameterList instance
        ToPdfParameterList ppl=new ToPdfParameterList();

        //Embed all fonts in the PDF document
        ppl.isEmbeddedAllFonts(true);

        //Remove the hyperlinks and keep the character formats
//        ppl.setDisableLink(true);

        //Set the output image quality as 40% of the original image. 80% is the default setting.
//        doc.setJPEGQuality(40);
        //Save the document as PDF
        doc.saveToFile("output/ToPDF.pdf", FileFormat.PDF);

    }

    private void convertion(Document doc, String convertTo, String resultFileName) throws IOException {
        switch (convertTo) {
            case "PDF":
                doc.saveToFile(resultFileName+".pdf", FileFormat.PDF);
                break;
            case "XPS":
                doc.saveToFile(resultFileName + ".xps", FileFormat.XPS);
                break;
            case "IMAGE":
                BufferedImage[] images = doc.saveToImages(ImageType.Bitmap);
                if (images != null && images.length > 0){
                    if (images.length == 1){
                        ImageIO.write(images[0],".PNG", new File(resultFileName+".png"));
                    }else {
                        for (int j = 0; j < images.length;j++){
                            String fileName = String.format("image-{0}.png",j);
                            ImageIO.write(images[j],".PNG",new File(fileName));
                        }
                    }
                }
                break;
            case "RTF":
                doc.saveToFile(resultFileName+".rtf", FileFormat.Rtf);
                break;
            case "TIFF": doc.saveToTiff(resultFileName +".tiff");
                break;
            case "HTML":
                doc.getHtmlExportOptions().setImageEmbedded(true);
                doc.getHtmlExportOptions().setCssStyleSheetType(CssStyleSheetType.Internal);
                doc.saveToFile(resultFileName+".html", FileFormat.Html);
                break;
        }
    }

}
