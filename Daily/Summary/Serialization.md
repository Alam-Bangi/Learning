## What is Serialization?
```
Serialization
    Converts an object’s state into a byte stream
Deserialization
    Rebuilds the object from that byte stream
Why Is Serialization Needed?
    Saving Objects – Write to files or databases
    Transferring Objects – Send across networks (e.g., sockets, APIs)
    Caching – Store objects for faster reuse
    Distributed Systems – Transfer data between JVMs
Think of It Like:
    Packing your object into a suitcase (byte stream) so it can travel!
    Then unpacking it at the destination to bring it back to life!
```
## How to Serialize an Object?
```
Step 1: 
    Class must implement Serializable
    Marker Interface – Serializable has no methods
    Tells the JVM that this class can be serialized
Step 2: 
    Use ObjectOutputStream to write the object
Step 3: 
    Save it to a .ser file
Example: Serializing a Rectangle Object
    import java.io.FileOutputStream;
    import java.io.ObjectOutputStream;
    import java.io.Serializable;

    class Rectangle implements Serializable {
        int length, breadth, area; 

        public Rectangle(int length, int breadth) {
            this.length = length;
            this.breadth = breadth;
            this.area = length * breadth;
        }
    }
    public class SerializationExample {
        public static void main(String[] args) throws Exception {
            FileOutputStream fileStream = new FileOutputStream("Rectangle.ser");
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
            // Serializing object
            Rectangle rect = new Rectangle(5, 6);
            objectStream.writeObject(rect);  
            objectStream.close();
            System.out.println("Rectangle object serialized.");
        }
    }
```
## How to Deserialize an Object in Java?
```
Deserialization – Reconstructs an object from a byte stream
Used For – Reading back previously saved or transmitted objects
How Does It Work?
    Reads the .ser file using ObjectInputStream
    Converts the byte stream back into a Java object
    Requires the class to be present on the classpath
Example: Deserialization of a Rectangle Object
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializationExample {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("Rectangle.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Rectangle rectangle = (Rectangle) objectInputStream.readObject(); 
        objectInputStream.close();
        System.out.println("Length: " + rectangle.length);   // 5
        System.out.println("Breadth: " + rectangle.breadth); // 6
        System.out.println("Area: " + rectangle.area);       // 30
    }
}
```
## How to Exclude Specific Parts of an Object from Serialization?
```
Why Use transient?
    What? Marks a field to be skipped during serialization
    Why? Some data shouldn’t or doesn’t need to be saved
Common Use Cases:
    Sensitive Data – Passwords, secrets, API keys
    Derived Fields – Values that can be recomputed
    Non-Serializable Fields – Like Thread, Socket, Logger, etc.
    Use transient when saving that field is unnecessary, risky, or problematic.
Example: Marking area as transient
import java.io.Serializable;
class Rectangle implements Serializable {
    int length;
    int breadth;
    transient int area;  // Not serialized
    public Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
        this.area = length * breadth;
    }
}
Deserialization Output:
    Length: 5
    Breadth: 6
    Area: 0   // ❌ Area is lost because it was marked as transient
Remember: Static variables belong to the class, not an instance.
Since serialization works on objects, static variables are ignored.
```
## Are Constructors Invoked During Deserialization?
```
    No. When an object is deserialized, constructors are NOT called.
    The object is restored directly from the byte stream with its previous state.
Example: Checking if Constructor is Called
    import java.io.*;
    class Demo implements Serializable {
        public Demo() {
            System.out.println("Constructor called!");
        }
    }
    public class ConstructorCheck {
        public static void main(String[] args) throws Exception {
            // Serialization
            System.out.println("Serialization Started");
            FileOutputStream fos = new FileOutputStream("Demo.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // Constructor will be called here
            oos.writeObject(new Demo());  
            oos.close();
            System.out.println("Serialization Done");

            // Deserialization
            System.out.println("Deserialization Started");
            FileInputStream fis = new FileInputStream("Demo.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Demo d = (Demo) ois.readObject();
            ois.close();
            System.out.println("Deserialization Done");
        }
    }
Output:
    Serialization Started
    Constructor called!
    Serialization Done
    Deserialization Started
    Deserialization Done
During Deserialization: No constructor message appears, confirming constructors are not executed during Deserialization.
```
## What is serialVersionUID and Why Is It Important?
```
    serialVersionUID: Unique identifier used by Java to verify object compatibility during deserialization
    No serialVersionUID? – JVM generates it automatically based on class structure
    Structure Changes? – Even a small change creates a different UID
    Breaks Compatibility – Old serialized objects can’t be deserialized with the new class
    Throws Exception – Causes InvalidClassException at runtime
    Fix? – Define serialVersionUID manually to keep versioning under control
    private static final long serialVersionUID = 123456789L;
Why Is serialVersionUID Important?
    Controls Class Versioning → Allows developers to explicitly define compatibility rules.
    Ensures Backward Compatibility → Helps deserialize older versions of an object even if the class has changed slightly.
Example Without serialVersionUID
    If a class is modified after serialization without a serialVersionUID, Java generates a new UID automatically, breaking compatibility.
import java.io.*;
class Rectangle implements Serializable {
    int length;
    int breadth;
    public Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }
}
Step 1: Serialize the Object
    FileOutputStream fileStream = new FileOutputStream("Rectangle.ser");
    ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
    objectStream.writeObject(new Rectangle(5, 6));
    objectStream.close();
Step 2: Modify the Class (Add a New Field)
    class Rectangle implements Serializable {
        int length;
        int breadth;
        int area;  // New field added
    }
Step 3: Try to Deserialize (Fails)
    FileInputStream fileInputStream = new FileInputStream("Rectangle.ser");
    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
    Rectangle rectangle  // ❌ Throws InvalidClassException
        = (Rectangle) objectInputStream.readObject(); 
    objectInputStream.close();

Fix: Explicitly Define serialVersionUID
    By manually specifying serialVersionUID, Java ensures that even after modifying the class, deserialization works as expected (if changes are compatible).

    class Rectangle implements Serializable {
        private static final long serialVersionUID = 123456789L;
        int length;
        int breadth;
        int area;  // New field added
    }

What should you do?
Change	                        Recommended Action
Add a new non-transient field	✅ Keep serialVersionUID (Compatible)
Remove an existing field	    ❌ Update serialVersionUID (Breaks compatibility)
Change field data type	        ❌ Update serialVersionUID (Incompatible)
Change method logic	            ✅ Keep serialVersionUID (No effect on serialization)

Key Takeaway: Update serialVersionUID only if changes break compatibility (e.g., removing a field or changing its type).
```
## What is Externalizable and Its Advantages Over Serializable?
```
    What? Externalizable gives you full control over what gets serialized and how
    How? You must implement both writeExternal() and readExternal() methods
    Why? To customize, compress, or skip unnecessary fields
    Difference from Serializable? Java auto-handles Serializable; you write logic manually with Externalizable
    When to Use? For selective serialization
Key Differences: Serializable vs. Externalizable

Feature	                Serializable	                            Externalizable
Serialization           Control	Java handles automatically	        Developer manually writes serialization logic
Performance	            Slower (writes all fields)	                Faster (only necessary fields are serialized)
Customization	        No control over fields being serialized	    Full control (can skip fields, encrypt data)
Constructor Invocation	Skips constructor while deserialization	    Calls default constructor when deserializing
Methods to Implement	No methods (marker interface)	            writeExternal() and readExternal()
Use Case	            Simple serialization	                    Performance-critical applications, security-sensitive data

Example: Using Externalizable for Custom Serialization
    import java.io.*;
    class Rectangle implements Externalizable {
        int length;
        int breadth;
        transient int area;
        // Default constructor required for Externalizable
        public Rectangle() {

        }  
        public Rectangle(int length, int breadth) {
            this.length = length;
            this.breadth = breadth;
            this.area = length * breadth;
        }
        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeInt(length);
            out.writeInt(breadth);
        }
        @Override
        public void readExternal(ObjectInput in) throws IOException {
            length = in.readInt();
            breadth = in.readInt();
            // Recalculate area
            area = length * breadth;  
        }
    }

Serialization & Deserialization Using Externalizable
    public class ExternalizableExample {
        public static void main(String[] args) throws Exception {
            Rectangle rect = new Rectangle(5, 6);
            // Serialization
            FileOutputStream fos = new FileOutputStream("RectangleExternal.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(rect);
            oos.close();
            // Deserialization
            FileInputStream fis = new FileInputStream("RectangleExternal.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Rectangle deserializedRect = (Rectangle) ois.readObject();
            ois.close();
            System.out.println("Length: " + deserializedRect.length);
            System.out.println("Breadth: " + deserializedRect.breadth);
            System.out.println("Area: " + deserializedRect.area);
        }
    }
Why Use Externalizable?
    More efficient → Avoids serializing unnecessary fields.
    More control → Manually control encryption, compression, and transient fields.
    Custom initialization → Allows recalculating transient values like area.
```