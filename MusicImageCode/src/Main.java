import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.imageio.ImageIO;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;




public class Main {

	public static void main(String[] args) throws IOException {
		//playMusic();
		
		JSONObject jsonObject = createJsonFromImage();
		
		createImageFromJson(jsonObject);
	}

	private static void createImageFromJson(JSONObject jsonObject) throws IOException {
		String encodedImage = (String) jsonObject.get("image");
		getImageFromString(encodedImage);
	}

	private static void getImageFromString(String encodedImage) throws IOException {
		
		byte[] data = Base64.getDecoder().decode(encodedImage);
		
		try (OutputStream stream = new FileOutputStream("xrayDiffractionDecode.jpg")) {
		    stream.write(data);
		}
	}

	private static JSONObject createJsonFromImage() throws IOException {
		
		String encodedImage = getStringFromImage();

		JSONObject jsonObj = (JSONObject) JSONValue.parse("{\"image\":\"" + encodedImage + "\"}");
		return jsonObj;
	}

	private static String getStringFromImage() throws IOException {
		
		BufferedImage originalImage = ImageIO.read(new File("xrayDiffraction.jpg"));
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write( originalImage, "jpg", baos );
		baos.flush();
	
		byte[] imageInByte = baos.toByteArray();
		baos.close();
		
		String encoded = Base64.getEncoder().encodeToString(imageInByte);
		return encoded;
	}

	private static void playMusic() {
		
		new JFXPanel();
		String bip = "Somebody.mp3";
		Media hit = new Media(new File(bip).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(hit);
		mediaPlayer.play();
	}
	
	
}
