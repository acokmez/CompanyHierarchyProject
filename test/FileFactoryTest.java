/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JTextPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author acokm
 */
public class FileFactoryTest {
    
    /**
     * Test of getExtensionOfFile method, of class FileFactory.
     */
    @Test
    public void testGetExtensionOfFile() {
        //Given
        String fileName = "girdi.txt";
        JTextPane textPane= new JTextPane();
        textPane.setText("Bu bir test denemesidir.");
        FileFactory fc = new FileFactory();
        //When
        String result = fc.getExtensionOfFile(fileName);
        //Then
        assertEquals("txt", result);
    }
    
}
