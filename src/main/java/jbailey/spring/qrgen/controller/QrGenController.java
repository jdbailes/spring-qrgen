package jbailey.spring.qrgen.controller;

import java.io.ByteArrayOutputStream;
import net.glxn.qrgen.javase.QRCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QrGenController {

  @ResponseBody
  @GetMapping(value = "/qr-code-stream", produces = MediaType.IMAGE_JPEG_VALUE)
  public byte[] getCodeAsStream() {

    ByteArrayOutputStream stream = QRCode.from("joebailey.me")
        .withSize(750, 750)
        .stream();

    return stream.toByteArray();
  }
}
