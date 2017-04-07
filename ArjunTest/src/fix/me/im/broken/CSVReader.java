package fix.me.im.broken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * read CSV file in given path and return a Map of: zipcode to list of PersonInfo beans.
 * CSV can be of the format:
 * "abcd", "efgh", "25", "27519"
 * abcd, efgh, 26, 98712
 * 
 * One row per line. Excerpt from a file is like so:
 * <p>
 * 
 * lastname,firstname,age,zipcode
 * Stark, Tony, 48, 11002
 * Rider, Knight, 50, 34008
 * "Widow","Black","38",34008
 */
public class CSVReader {

    /**
     * read CSV file in given path and return a Map of: zipcode to list of PersonInfo beans.
     * CSV can be of the format:
     * "abcd", "efgh", "25", "27519"
     * abcd, efgh, 26, 98712
     * 
     * One row per line. Excerpt from a file is like so:
     * <p>
     * 
     * lastname,firstname,age,zipcode
     * Stark, Tony, 48, 11002
     * Rider, Knight, 50, 34008
     * "Widow","Black","38",34008
     * 
     * </p>
     * @param csvPath, absolute pathname of the csv file.
     * @return Map<String, List<PersonInfo>> list of {@link PersonInfo} instances mapped to zipcodes.
     * @throws IOException if failed to close the csv file.
     */
    public Map<String, List<PersonInfo>> readCSV(String csvPath) {
        Map<String, List<PersonInfo>> pMap = new HashMap<String, List<PersonInfo>>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(csvPath));
            String line = "";

            while ((line = br.readLine()) != null) {
                // simply string.split. Nothing fancy.
                String[] details = line.split(",");
                // assume each line has atleast 4 entries after split.
                PersonInfo info = new PersonInfo();
                info.setLastName(details[0]);
                info.setFirstName(details[1]);

                try {
                    info.setAge(Integer.parseInt(details[2]));
                } catch (NumberFormatException nfe) {
                    // handle this condition. but silently.
                    info.setAge(66);
                }
                info.setZipcode(details[3]);

                List<PersonInfo> persons = pMap.get(info.getZipcode());
                if (persons == null || (persons != null && persons.isEmpty())) {
                    persons = new ArrayList<PersonInfo>();
                    persons.add(info);
                    pMap.put(info.getZipcode(), persons);
                } else {
                    pMap.get(info.getZipcode()).add(info);
                }
            }
        } catch(FileNotFoundException fnfe) {
            System.err.println("Oh oh!");
            fnfe.printStackTrace();
        } catch (IOException ie) {
            System.err.println("Oh oh!!");
            ie.printStackTrace();
        } catch (Exception e) {
            System.err.println("Oh oh, shit happened.");
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                  e.printStackTrace();
                }
            }
        }
        return pMap;
    }

    /**
     * pretty print PersonInfo 
     */
    public void printInfo(Map<String, List<PersonInfo>> map) {
        System.out.println("########################################");
        System.out.println("#      Person details by zipcode       #");
        for (String zipcode : map.keySet()) {
            StringBuilder line = new StringBuilder();
            line.append(zipcode + " : ");
            for (PersonInfo person : map.get(zipcode)) {
                line.append(person.getLastName() + ", " + person.getFirstName() + ", "+ person.getAge()+"|");
            }
            System.out.println(line.toString());
        }
    }

    /**
     * run like so:
     * $ java -jar <path-to-fixme.jar> fix.me.im.broken.CSVReader /a/b/c/input.csv
     *  
     * @param args, full path of the csv file
     */
    public static void main(String[] args) {
        System.out.println("Welcome!");
        if (args.length == 0) {
            System.out.println("Please enter _full_ path of the CSV file in arguments.");
        } else {
            CSVReader reader = new CSVReader();
            System.out.println("## Reading file [" + args[0] + "]");
            reader.printInfo(reader.readCSV(args[0]));
            System.out.println("Thank you!");
        }
    }
}
