//BufferedInputFile.java
//force all the lines in the LinkedList to uppercase and send the results in reverse order
//
//1).   Java 1.1 added new classes into the InputStream and OutputStream hierarchy;
//    Reader and Writer hierarchies were added to support Unicode in all I/O operation.
//
//    So the most sensible approach to take is to try to use the Reader and Writer classes whenever we can;
//    We'll discover the situations when we have to use the byte-oriented libraries because our code won't compile.
//
//    ASCII is a TEXT file so we would use Readers for reading. Java also supports reading from a binary file using InputStreams.
//    
//
//2)    For InputStreams and OutputStreams, streams were adapted for particular needs using "decorator" subclasses of FilterInputStream and FilterOutputStream.
//    The Reader and Writer class hierarchies continue the use of this idea.
import java.io.IOException;
//whenever we want to use readLine(), we shouldn't do it with a DataInputStream, but instead use a BufferedReader.
import java.io.BufferedReader;
//FileReader inherits from the InputStreamReader class. FileReader is used for reading streams of characters.
import java.io.FileReader;
import java.util.LinkedList;

public class BufferedInputFile {
    public static String read(String filename) throws IOException {
        //Reading input by lines:
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        LinkedList<String> list = new LinkedList<String>();
        //StringBuilder is used to accumulate the entire contents of the file
        StringBuilder sb = new StringBuilder();

        //add each line to LinkedList
        while((s = in.readLine()) != null)
            list.add(s.toUpperCase());//
        
        while(list.peekLast() != null) //while there is a last line
            sb.append(list.pollLast() + "\n"); 

        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        if(args.length != 1){
            System.out.println("Usage: enter file name");
            System.exit(1);
        }
        
        System.out.print(read(args[0]));
    }
    
}

