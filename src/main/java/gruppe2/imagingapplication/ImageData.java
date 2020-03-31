package gruppe2.imagingapplication;


import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.drew.metadata.Metadata;
import gruppe2.imagingapplication.serializableclasses.MetadataSerializable;
import javafx.scene.image.Image;

import javax.persistence.*;


/**
 * A class representing an image with metadata and tags.
 */
@Entity
public class ImageData implements Serializable {
  @Id
  private String path;
  private String imageName;
  @ElementCollection
  private List<String> tags;
  @Transient
  private MetadataSerializable metadata;
  @Transient
  private Image image;

  /**
   * This is a constructor for the Image class.
   *
   * @param absolutePath The absolute path to the image for the class to represent
   * @param tags         User-defined tags to describe image, set null for no tags
   * @throws ImageProcessingException If filetype is unknown
   * @throws IOException              If file could not be found
   */
  public ImageData(String absolutePath, List<String> tags) throws
      ImageProcessingException, IOException {
    this.path = absolutePath;
    this.imageName = "";
    this.metadata = new MetadataSerializable(ImageMetadataReader.readMetadata(new File(path)));
    this.image = new Image("file:"+absolutePath);
    if (tags != null) {
      this.tags = tags;
    } else {
      this.tags = new ArrayList<>();
    }
  }

  public ImageData() {

  }

  public String getImageName() {
    return imageName;
  }

  public void setImageName(String imageName) {
    this.imageName = imageName;
  }

  public List<String> getTags() {
    return tags;
  }


  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public Metadata getMetadata() {
    return metadata.getMetadata();
  }

  public Image getImage() {
    return image;
  }

  public void setImage(Image image) {
    this.image = image;
  }
}
