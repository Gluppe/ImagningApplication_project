package gruppe2.imagingapplication.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class GalleryPageController implements Initializable {
  Logger logger = LoggerFactory.getLogger(GalleryPageController.class);

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
  }

  /**
   * This method handles what happens when the home button is pressed.
   */
  @FXML
  private void buttonHome(ActionEvent event) {
    logger.info("Home button pressed");
  }

  /**
   * This method handles what happens when the add image button is pressed.
   */
  @FXML
  private void buttonAddImage(ActionEvent event) {
    logger.info("Add image button pressed");
  }

  /**
   * This method handles what happens when the export button is pressed.
   */
  @FXML
  private void buttonExport(ActionEvent event) {
    logger.info("Export button pressed");
  }
}