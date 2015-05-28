package io.swagger.api;

import io.swagger.model.*;

import io.swagger.model.WelcomeMessage;
import io.swagger.model.Error;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.springframework.http.MediaType.*;

@Controller
@RequestMapping(value = "/helloworld", produces = {APPLICATION_JSON_VALUE})
@Api(value = "/helloworld", description = "the helloworld API")
public class HelloworldApi {
  

  @ApiOperation(value = "Gives you a warm greeting", notes = "Returns a gretting given a name as an input\n", response = WelcomeMessage.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "An warm welcome message"),
    @ApiResponse(code = 0, message = "Unexpected error") })
  @RequestMapping(value = "", 
    
    
    method = RequestMethod.GET)
  public ResponseEntity<WelcomeMessage> helloworldGet(@ApiParam(value = "The name to greet.",required=true) @RequestParam("name") String name)
      throws NotFoundException {
      // do some magic!
      return new ResponseEntity<WelcomeMessage>(HttpStatus.OK);
  }

  
}
