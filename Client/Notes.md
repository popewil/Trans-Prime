PRE-REQUISITES
- Confirm that java and shared directory are available on Thor and Zeus.


WORKFLOW
Read in local configuration file
    Fail if local configuration file is not available
    

Create variables for File being pushed 

NETWORK COMMUNICATION
Client  -> Server  Initial Connection
        <-    Ack
        ->    Request Push or Pull with file information
        
REQUEST STRUCTURE
- Filename
- File size in bytes
        
POSSIBLE USE CASES
Server loses connection with Client
Client loses connection with Server
Client pushes file that already exists on server

    

COMMAND INTERFACE
  Push: java -jar client.jar push <file location>
  Pull: java -jar client.jar pull <filename> 
    
CLIENT CONFIGURATION
Directory to save files to
Server Location
Server Port
Port for client to connect through
