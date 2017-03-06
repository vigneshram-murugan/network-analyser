import javax.swing.JOptionPane;
import jpcap.PacketReceiver;
import jpcap.packet.Packet;
import jpcap.packet.*;
public class PacketContents implements PacketReceiver 
{   
    public void receivePacket(Packet packet){
           int i=networkpacketanalyser.igraph;
           
           TCPPacket tcpobj;
           ARPPacket arpobj ;
           ICMPPacket icmpobj;
           
           if (packet instanceof ARPPacket) {
               networkpacketanalyser.arparr++;
               networkpacketanalyser.textarea.append("\nARP_DETECTED\n");
               
               if(networkpacketanalyser.arparr>30){
               JOptionPane.showMessageDialog(null, "ARP Flood Attack Detected."); 
               }
       }
           if (packet instanceof ICMPPacket) {
               networkpacketanalyser.textarea.append("\nICMPPacket_DETECTED\n");
               String b="ICMPPacket_warning";
               
          
               JOptionPane.showMessageDialog(null, b);
                              

       }
           networkpacketanalyser.arr[i] =packet.len;
           networkpacketanalyser.textarea.append(packet.toString()  +"\n---------------------------------------------------" +packet.len+
        "-----------------------------------------------------------\n\n");

    }
}

