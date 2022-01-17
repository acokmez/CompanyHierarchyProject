
public class FileFactory {
     //use getShape method to get object of type shape 
   public IGirdiFactory getFile(String extension){
      if(extension == null){
         return null;
      }		
      if(extension.equalsIgnoreCase("txt")){
         return new TxtFactory();
      } 
      return null;
   }
   public String getExtensionOfFile(String fileName) {
        //get file extension so we can implement Factory Design Pattern
        String extension = "";
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i+1);
        }
        return extension;
    }
}
