package fr.web.rest;

import java.net.InetAddress;
import java.net.URISyntaxException;
import java.net.UnknownHostException;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

import fr.security.AuthoritiesConstants;


@RestController
@RequestMapping("/wlog")
public class WebLogResource {


    @RequestMapping(
        method = RequestMethod.GET,
        produces = MediaType.TEXT_HTML_VALUE)
    @Timed
    @Secured(AuthoritiesConstants.ADMIN)
    public ResponseEntity<?> getLorRessource()
        throws URISyntaxException {

    	String host = null;
        try {
            host = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            host = "localhost";
        }    	
        
        String loc = "http://" + host + ":8765/logback.js";

        StringBuffer content = new StringBuffer("<html>")
        .append("<head>")
        .append("    <meta charset=\"utf-8\">")
		.append("    <title>SSE LOG</title>")
		.append("    <link rel=\"stylesheet\" href=\"content/css/main.css\">")
		.append("</head>")
		.append("<body>")
		.append("	<script type=\"text/javascript\" src=\"" + loc + "\"></script>")
		.append("</body>")
		.append("</html>");
        
        
        return ResponseEntity.ok(content.toString());
    }


}
