import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Main {
 private JFrame frame;
 private JTable table;
 private DefaultTableModel tableModel;
 private JsonFileReader jsonFileReader;
 private CSVFileReader csvFileReader;

 public Main() {
  // Skapar instanser av JsonFileReader och CSVFileReader
  jsonFileReader = new JsonFileReader();
  csvFileReader = new CSVFileReader();

  // Skapar huvudfönstret
  frame = new JFrame("File Reader App");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(600, 800);

  // Skapar knapp för att läsa JSON-fil
  JButton jsonButton = new JButton("Read Json file");
  jsonButton.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
    // Öppnar en filväljare för att välja JSON-fil
    JFileChooser fileChooser = new JFileChooser("C:\\Users\\Alex\\Desktop\\sample.json");
    int result = fileChooser.showOpenDialog(frame);
    if (result == JFileChooser.APPROVE_OPTION) {
     // Hämtar sökvägen till vald fil
     String filePath = fileChooser.getSelectedFile().getAbsolutePath();

     // Läser JSON-filen och visar datan i tabellen
     List<DataObject> data = jsonFileReader.readJsonFile(filePath);
     displayDataInTable(data);
    }
   }
  });

  // Skapar knapp för att läsa CSV-fil
  JButton csvButton = new JButton("Read CSV file");
  csvButton.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
    // Öppnar en filväljare för att välja CSV-fil
    JFileChooser fileChooser = new JFileChooser("C:\\Users\\Alex\\Desktop\\Sample.csv");
    int result = fileChooser.showOpenDialog(frame);
    if (result == JFileChooser.APPROVE_OPTION) {
     // Hämtar sökvägen till vald fil
     String filePath = fileChooser.getSelectedFile().getAbsolutePath();

     // Läser CSV-filen och visar datan i tabellen
     List<DataObject> data = csvFileReader.readCsvFile(filePath);
     displayDataInTable(data);
    }
   }
  });

  // Skapar tabell och dess modell
  tableModel = new DefaultTableModel();
  table = new JTable(tableModel);
  table.setAutoCreateRowSorter(true);
  table.setRowHeight(18);
  table.setFont(new Font("Arial", Font.PLAIN, 12));
  JScrollPane scrollPane = new JScrollPane(table);

  // Skapar en panel för knapparna
  JPanel buttonPanel = new JPanel(new FlowLayout());
  buttonPanel.add(jsonButton);
  buttonPanel.add(csvButton);

  // Lägger till knappanel och tabell i huvudfönstret
  frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
  frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
  frame.setVisible(true);
 }

 private void displayDataInTable(List<DataObject> data) {
  // Rensa befintlig data i tabellen
  tableModel.setRowCount(0);
  tableModel.setColumnCount(0);

  // Skapa kolumnnamn
  tableModel.setColumnIdentifiers(new Object[]{"A", "B", "C", "D", "E", "F", "G", "H"});

  if (data != null && !data.isEmpty()) {
   // Fyller tabellen med data från DataObject
   for (DataObject dataObject : data) {
    Object[] rowData = {
            dataObject.getA(),
            dataObject.getB(),
            dataObject.getC(),
            dataObject.getD(),
            dataObject.getE(),
            dataObject.getF(),
            dataObject.getG(),
            dataObject.getH()
    };
    tableModel.addRow(rowData);
   }
  }
 }

 public static void main(String[] args) {
  // Startar Swing-applikationen
  SwingUtilities.invokeLater(() -> new Main());
 }
}
