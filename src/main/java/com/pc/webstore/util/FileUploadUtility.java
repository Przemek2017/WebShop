package com.pc.webstore.util;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Przemek
 */
public class FileUploadUtility {

    private static final String ABS_PATH = "C:\\Users\\Przemek\\Documents\\NetBeansProjects\\WebStore\\src\\main\\webapp\\static\\images\\";
    private static String REAL_PATH = "";

    public static final Logger LOGGER = LoggerFactory.getLogger(FileUploadUtility.class);

    public static void getFile(HttpServletRequest request, MultipartFile file, String code) {
        REAL_PATH = request.getSession().getServletContext().getRealPath("/static/images/");
        LOGGER.info("REAL_PATH => " + REAL_PATH);

        // check directory
        if (!new File(ABS_PATH).exists()) {
            // create if not exists
            new File(ABS_PATH).mkdirs();
        }
        // check directory
        if (!new File(REAL_PATH).exists()) {
            // create if not exists
            new File(REAL_PATH).mkdirs();
        }

        try {
            // server upload
            file.transferTo(new File(REAL_PATH + code + ".jpg"));
            // project directory upload
            file.transferTo(new File(ABS_PATH + code + ".jpg"));
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage().toString());
        }
    }
}
