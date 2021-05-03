
public class Main {
    
    public static void main(String[] argumento) {
        CSVFile csv = new CSVFile("04be43ab919b6b22d950d3b59834f4a1.csv", true, false, 3);
        csv.createOriginalImage();

        Huffman huff = new Huffman(csv.getMatrix());
        huff.makeFrequencyList();
        csv.saveCompressedMatrix();
        csv.readEncodedCompresedFile();


        //System.out.println(Arrays.deepToString(matrix));

        // for(FrequencyValue node : huff.frequencylist){
        //     System.out.println(node.number + " : " + node.frequency);
        // }

        //System.out.println(Huffman.table.get(3).code);
        //System.out.println(Huffman.tableCodes.get("000").value);

        

        
    
    }
}
