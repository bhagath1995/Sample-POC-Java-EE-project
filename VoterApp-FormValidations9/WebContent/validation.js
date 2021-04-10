function validate(frm){
  alert("Client side form validations....");
  var name,age;
  //set vflag value  to true when JavaScript is executed
  frm.vflag.value="yes";
    //read form data
    name=frm.pname.value;
    age=frm.page.value;
    //empty the error messages
        document.getElementById("nameErr").innerHTML="";
        document.getElementById("ageErr").innerHTML="";
        
    //write client side form validations
    if(name==""){  //required rule -name
      document.getElementById("nameErr").innerHTML="Person name is required";
      frm.pname.focus();
      return false;
    }
    if(age==""){//required rule -age
     document.getElementById("ageErr").innerHTML="Person age is required";     
      frm.page.focus();
      return false;
    }
    else if(isNaN(age)){
     document.getElementById("ageErr").innerHTML="Person age must be numeric value";
      frm.page.focus();
      return false;
    }
    else if(age<=0 || age>150){
     document.getElementById("ageErr").innerHTML="Person age must be in the range 1-150";
      frm.page.focus();
      return false;
    }
    return true;
  }//function
