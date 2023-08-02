// Captures packets on network and displays info about captured packets to the terminal
package packet_analyzer

import java.util
import org.pcap4j.core.PcapHandle
import org.pcap4j.core.PcapNetworkInterface
import org.pcap4j.packet.Packet

class Analyzer:
    def capture() = 
        // Obtain a list of available network interfaces
        val networkInterfaces: util.List[PcapNetworkInterface] = org.pcap4j.core.Pcaps.findAllDevs()

        // Choose a network interface
        val networkInterface = networkInterfaces.get(0) // You may need to select the appropriate interface based on your system

        // Open the network interface for capturing packets
        val handle = networkInterface.openLive(65536, PcapNetworkInterface.PromiscuousMode.PROMISCUOUS, 10)

        try {
            // Start capturing packets (replace 100 with the desired number of packets)
            val packetCount = 100
            for (_ <- 1 to packetCount) {
                // Capture the next packet
                val packet: Packet = handle.getNextPacketEx
                println("Packet captured: " + packet)
                // Perform packet analysis here
            }
        } 
        catch {
            case ex: Exception => println("An error occurred: " + ex.getMessage)
        } 
        finally {
            // Close the handle once done
            handle.close()
        }
