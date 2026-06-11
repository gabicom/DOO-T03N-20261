import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class ClimaSwingApp extends JFrame {

    private JTextField campoCidade;
    private JTextArea areaResultado;

    private static final String API_KEY = "YNSH5SQNDK5FS7N8W3AKMKFJM";

    public ClimaSwingApp() {
        setTitle("App de Clima ☀️");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout
        setLayout(new BorderLayout());

        // Topo
        JPanel painelTopo = new JPanel();
        campoCidade = new JTextField(20);
        JButton botaoBuscar = new JButton("Buscar");

        painelTopo.add(new JLabel("Cidade:"));
        painelTopo.add(campoCidade);
        painelTopo.add(botaoBuscar);

        add(painelTopo, BorderLayout.NORTH);

        // Área de resultado
        areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        add(new JScrollPane(areaResultado), BorderLayout.CENTER);

        // Evento do botão
        botaoBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarClima();
            }
        });
    }

    private void buscarClima() {
        String cidade = campoCidade.getText().trim();

        if (cidade.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite uma cidade!");
            return;
        }

        try {
            String endpoint = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/"
                    + cidade + "?unitGroup=metric&key=" + API_KEY;

            URL url = new URL(endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );

            StringBuilder response = new StringBuilder();
            String linha;

            while ((linha = reader.readLine()) != null) {
                response.append(linha);
            }
            reader.close();

            JSONObject json = new JSONObject(response.toString());

            JSONObject atual = json.getJSONObject("currentConditions");

            double tempAtual = atual.getDouble("temp");
            double umidade = atual.getDouble("humidity");
            String condicao = atual.getString("conditions");
            double ventoVel = atual.getDouble("windspeed");
            double ventoDir = atual.getDouble("winddir");
            double precipitacao = atual.optDouble("precip", 0.0);

            JSONArray dias = json.getJSONArray("days");
            JSONObject hoje = dias.getJSONObject(0);

            double tempMax = hoje.getDouble("tempmax");
            double tempMin = hoje.getDouble("tempmin");

            // Atualizar interface
            areaResultado.setText(
                    "🌤 Clima em " + cidade + "\n\n" +
                    "Temperatura atual: " + tempAtual + "°C\n" +
                    "Máxima: " + tempMax + "°C\n" +
                    "Mínima: " + tempMin + "°C\n" +
                    "Umidade: " + umidade + "%\n" +
                    "Condição: " + condicao + "\n" +
                    "Precipitação: " + precipitacao + " mm\n" +
                    "Vento: " + ventoVel + " km/h\n" +
                    "Direção do vento: " + ventoDir + "°\n"
            );

        } catch (Exception ex) {
            areaResultado.setText("Erro ao buscar dados 😢\n" + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ClimaSwingApp().setVisible(true);
        });
    }
}