import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class DataOutputStream {

    public static void main(String[] args) {
        ByteArrayOutputStream bos = null;
        java.io.DataOutputStream dos = null;

        byte[] result = null;

        try {
            bos = new ByteArrayOutputStream();
            dos = new java.io.DataOutputStream(bos);

            dos.writeInt(10);
            dos.writeFloat(20.0f);
            dos.writeBoolean(true);

            result = bos.toByteArray();
            String[] hex = new String[result.length];
            for (int i = 0; i < result.length; i++) {
                if (result[i] < 0) { hex[i] = String.format("%02x", result[i] + 256); } else {
                    hex[i] = String.format("%02x", result[i]);
                }
            }
            System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
            System.out.println("Arrays.toString(hex) = " + Arrays.toString(hex));
            dos.flush();
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
