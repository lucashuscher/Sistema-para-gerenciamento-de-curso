package view;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Cadastros.CadastrarHoraCafe;
import Cadastros.CadastrarPessoas;
import Cadastros.CadastrarSalas;
import imp.HoraCafe;
import imp.Pessoa;
import imp.Sala;
import interfaces.IHoraCafe;
import interfaces.IPessoa;
import interfaces.ISala;

public class Geral {

	private JFrame frame;
	private JLayeredPane layeredPane = new JLayeredPane();
	private JTable tablePessoas;
	private JTextField tFNomePessoa;
	private JTextField tFSobrenome;
	DefaultTableModel modelPessoas;
	private JTextField tFNomeSala;
	private JTextField tFLotacaoSala;
	private JTable tableSalas;
	DefaultTableModel modelSalas;
	private JTextField tFNomeCafe;
	private JTextField tFLotacaoCafe;
	private JTable tableCafe;
	DefaultTableModel modelCafe;
	private JPanel panelSalas;
	private JPanel panelCafe;

	private static CadastrarPessoas cadastrarPessoas = new CadastrarPessoas();
	private static CadastrarSalas cadastrarSalas = new CadastrarSalas();
	private static CadastrarHoraCafe cadastrarHoraCafe = new CadastrarHoraCafe();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Geral window = new Geral();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Geral() {
		initialize();
	}

	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 691, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		layeredPane.setBounds(10, 95, 572, 246);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));

		final JPanel panelGeral = new JPanel();
		layeredPane.add(panelGeral, "name_1141937608271000");
		panelGeral.setLayout(null);

		JLabel lblGeralTitulo = new JLabel("Geral");
		lblGeralTitulo.setBounds(21, 11, 46, 14);

		panelGeral.add(lblGeralTitulo);

		//inicializa os formulários de cadastro
		initializePessoas();
		initializeSalas();		
		initializeHoraCafe();
		
		JButton btnGeral = new JButton("Incluir/consultar pessoas nas salas");
		btnGeral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelGeral);
			}
		});
		btnGeral.setBounds(10, 45, 284, 23);
		frame.getContentPane().add(btnGeral);

		JButton btnPessoas = new JButton("Cadastro/Consulta de Pessoas");
		btnPessoas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelPessoas);
			}
		});
		btnPessoas.setBounds(10, 11, 217, 23);
		frame.getContentPane().add(btnPessoas);

		JButton btnSalas = new JButton("Cadastro/consulta de salas");
		btnSalas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelSalas);
			}
		});
		btnSalas.setBounds(227, 11, 209, 23);
		frame.getContentPane().add(btnSalas);

		JButton btnCafe = new JButton("Cadastro/consulta de Espa\u00E7o/Caf\u00E9");
		btnCafe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelCafe);
			}
		});
		btnCafe.setBounds(436, 11, 229, 23);
		frame.getContentPane().add(btnCafe);
	}

	JPanel panelPessoas;

	private void initializePessoas() {
		panelPessoas = new JPanel();
		layeredPane.add(panelPessoas, "name_1142001296280400");
		panelPessoas.setLayout(null);

		JLabel lblPessoasTitulo = new JLabel("Pessoas");
		lblPessoasTitulo.setBounds(10, 11, 114, 14);
		panelPessoas.add(lblPessoasTitulo);

		JScrollPane scrollPanePessoas = new JScrollPane();
		scrollPanePessoas.setBounds(278, 11, 284, 224);
		panelPessoas.add(scrollPanePessoas);

		tablePessoas = new JTable();
		tablePessoas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tablePessoas.getSelectedRow();
				tFNomePessoa.setText(modelPessoas.getValueAt(i, 0).toString());
				tFSobrenome.setText(modelPessoas.getValueAt(i, 1).toString());
			}
		});
		scrollPanePessoas.setViewportView(tablePessoas);
		modelPessoas = new DefaultTableModel();
		Object[] columnPessoas = { "Nome", "Sobrenome" };
		tablePessoas.setModel(modelPessoas);
		modelPessoas.setColumnIdentifiers(columnPessoas);

		JLabel lblNomePessoa = new JLabel("Nome");
		lblNomePessoa.setBounds(10, 46, 46, 14);
		panelPessoas.add(lblNomePessoa);

		tFNomePessoa = new JTextField();
		tFNomePessoa.setBounds(90, 43, 178, 20);
		panelPessoas.add(tFNomePessoa);
		tFNomePessoa.setColumns(10);

		JLabel lblSobrenomePessoa = new JLabel("Sobrenome");
		lblSobrenomePessoa.setBounds(10, 78, 72, 14);
		panelPessoas.add(lblSobrenomePessoa);

		tFSobrenome = new JTextField();
		tFSobrenome.setBounds(90, 75, 178, 20);
		panelPessoas.add(tFSobrenome);
		tFSobrenome.setColumns(10);

		cadastrarPessoas();
		atualizarPessoas();
		removerPessoas();
	}

	private void cadastrarPessoas() {
		JButton btnAddPessoa = new JButton("Adicionar");
		btnAddPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tFNomePessoa.getText().equals("") || tFSobrenome.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor, Informe um nome e sobrenome!");
				} else {
					IPessoa pessoa = new Pessoa();
					pessoa.setName(tFNomePessoa.getText());
					pessoa.setSobrenone(tFSobrenome.getText());
					cadastrarPessoas.addPessoa(pessoa);
					modelPessoas.addRow(new Object[] { pessoa.getName(), pessoa.getSobrenome() });

					tFNomePessoa.setText("");
					tFSobrenome.setText("");
					JOptionPane.showMessageDialog(null, "Cadastro salvo!");
				}
			}
		});
		btnAddPessoa.setBounds(0, 144, 89, 23);
		panelPessoas.add(btnAddPessoa);

	}

	private void atualizarPessoas() {
		JButton btnAtualizarPessoa = new JButton("Atualizar");
		btnAtualizarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tablePessoas.getSelectedRow();
				if (i >= 0) {
					IPessoa pessoa = new Pessoa();
					pessoa.setName(tablePessoas.getModel().getValueAt(i, 0).toString());
					pessoa.setSobrenone(tablePessoas.getModel().getValueAt(i, 1).toString());

					cadastrarPessoas.atualizarPessoa(pessoa, tFNomePessoa.getText(), tFSobrenome.getText());

					modelPessoas.setValueAt(tFNomePessoa.getText(), i, 0);
					modelPessoas.setValueAt(tFSobrenome.getText(), i, 1);

					tFNomePessoa.setText("");
					tFSobrenome.setText("");
					JOptionPane.showMessageDialog(null, "Cadastro atualizado!");
				} else {
					JOptionPane.showMessageDialog(null, "Por favor, selecione uma Pessoa!");
				}
			}
		});
		btnAtualizarPessoa.setBounds(0, 178, 89, 23);
		panelPessoas.add(btnAtualizarPessoa);
	}

	private void removerPessoas() {
		JButton btnDeletarPessoa = new JButton("Deletar");
		btnDeletarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tablePessoas.getSelectedRow();
				if (i >= 0) {
					IPessoa pessoa = new Pessoa();
					pessoa.setName(tablePessoas.getModel().getValueAt(i, 0).toString());
					pessoa.setSobrenone(tablePessoas.getModel().getValueAt(i, 1).toString());

					cadastrarPessoas.deletarPessoa(pessoa);

					modelPessoas.removeRow(i);

					tFNomePessoa.setText("");
					tFSobrenome.setText("");
					JOptionPane.showMessageDialog(null, "Deletado!");
				} else {
					JOptionPane.showMessageDialog(null, "Por favor, selecione uma Pessoa para deletar!");
				}
			}
		});
		btnDeletarPessoa.setBounds(0, 212, 89, 23);
		panelPessoas.add(btnDeletarPessoa);
	}

	private void initializeSalas() {
		panelSalas = new JPanel();
		layeredPane.add(panelSalas, "name_1142004090258300");
		panelSalas.setLayout(null);

		JLabel lblSalasTitulo = new JLabel("Salas");
		lblSalasTitulo.setBounds(10, 11, 46, 14);
		panelSalas.add(lblSalasTitulo);

		JScrollPane scrollPaneSalas = new JScrollPane();
		scrollPaneSalas.setBounds(307, 11, 255, 224);
		panelSalas.add(scrollPaneSalas);

		tableSalas = new JTable();
		tableSalas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tableSalas.getSelectedRow();
				tFNomeSala.setText(modelSalas.getValueAt(i, 0).toString());
				tFLotacaoSala.setText(modelSalas.getValueAt(i, 1).toString());
			}
		});
		scrollPaneSalas.setViewportView(tableSalas);
		modelSalas = new DefaultTableModel();
		Object[] columnSalas = { "Nome da Sala", "Lotação" };
		tableSalas.setModel(modelSalas);
		modelSalas.setColumnIdentifiers(columnSalas);

		JLabel lblNomeSala = new JLabel("Nome: ");
		lblNomeSala.setBounds(10, 36, 46, 14);
		panelSalas.add(lblNomeSala);

		JLabel lblLotacao = new JLabel("Lota\u00E7\u00E3o: ");
		lblLotacao.setBounds(10, 61, 46, 14);
		panelSalas.add(lblLotacao);

		tFNomeSala = new JTextField();
		tFNomeSala.setBounds(92, 33, 205, 20);
		panelSalas.add(tFNomeSala);
		tFNomeSala.setColumns(10);

		tFLotacaoSala = new JTextField();
		tFLotacaoSala.setBounds(92, 58, 205, 20);
		panelSalas.add(tFLotacaoSala);
		tFLotacaoSala.setColumns(10);
		cadastrarSalas();
		atualizarSalas();
		removerSalas();
	}

	private void cadastrarSalas() {
		JButton btnAdicionarSala = new JButton("Adicionar");
		btnAdicionarSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tFNomeSala.getText().equals("") || tFLotacaoSala.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor, Informe um nome e lotação!");
				} else {
					try {
						ISala sala = new Sala();
						sala.setSala(tFNomeSala.getText());
						sala.setCapacidade(Integer.parseInt(tFLotacaoSala.getText()));
						cadastrarSalas.addSala(sala);
						modelSalas.addRow(new Object[] { sala.getSala(), sala.getCapacidade() });

						tFNomeSala.setText("");
						tFLotacaoSala.setText("");
						JOptionPane.showMessageDialog(null, "Cadastro salvo!");
					} catch (Exception excp) {
						JOptionPane.showMessageDialog(null, "A lotação da sala deve ser um numero!");
					}
				}
			}
		});
		btnAdicionarSala.setBounds(0, 123, 89, 23);
		panelSalas.add(btnAdicionarSala);
	}

	private void atualizarSalas() {
		JButton btnAtualizarSala = new JButton("Atualizar");
		btnAtualizarSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tableSalas.getSelectedRow();
				if (i >= 0) {
					try {
						ISala sala = new Sala();
						sala.setSala(tableSalas.getModel().getValueAt(i, 0).toString());
						sala.setCapacidade(Integer.parseInt(tableSalas.getModel().getValueAt(i, 1).toString()));
						cadastrarSalas.atualizarSala(sala, tFNomeSala.getText(),
								Integer.parseInt(tFLotacaoSala.getText()));

						modelSalas.setValueAt(tFNomeSala.getText(), i, 0);
						modelSalas.setValueAt(tFLotacaoSala.getText(), i, 1);

						tFNomeSala.setText("");
						tFLotacaoSala.setText("");
						JOptionPane.showMessageDialog(null, "Cadastro atualizado!");
					} catch (Exception excp) {
						JOptionPane.showMessageDialog(null, "A lotação da sala deve ser um numero!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Por favor, selecione uma Sala!");
				}
			}
		});
		btnAtualizarSala.setBounds(0, 157, 89, 23);
		panelSalas.add(btnAtualizarSala);
	}

	private void removerSalas() {
		JButton btnDeletarSala = new JButton("Deletar");
		btnDeletarSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tableSalas.getSelectedRow();
				if (i >= 0) {
					ISala sala = new Sala();
					sala.setSala(tableSalas.getModel().getValueAt(i, 0).toString());
					sala.setCapacidade(0);

					cadastrarSalas.deletarSala(sala);

					modelSalas.removeRow(i);
					tFNomeSala.setText("");
					tFLotacaoSala.setText("");
					JOptionPane.showMessageDialog(null, "Deletado!");
				} else {
					JOptionPane.showMessageDialog(null, "Por favor, selecione uma Sala para deletar!");
				}
			}
		});
		btnDeletarSala.setBounds(0, 191, 89, 23);
		panelSalas.add(btnDeletarSala);
	}

	private void initializeHoraCafe() {
		panelCafe = new JPanel();
		layeredPane.add(panelCafe, "name_1143174547771400");
		panelCafe.setLayout(null);

		JLabel lblCafeTitulo = new JLabel("Caf\u00E9");
		lblCafeTitulo.setBounds(10, 11, 46, 14);
		panelCafe.add(lblCafeTitulo);

		JScrollPane scrollPaneCafe = new JScrollPane();
		scrollPaneCafe.setBounds(298, 11, 264, 224);
		panelCafe.add(scrollPaneCafe);

		tableCafe = new JTable();
		tableCafe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tableCafe.getSelectedRow();
				tFNomeCafe.setText(modelCafe.getValueAt(i, 0).toString());
				tFLotacaoCafe.setText(modelCafe.getValueAt(i, 1).toString());
			}
		});
		scrollPaneCafe.setViewportView(tableCafe);
		modelCafe = new DefaultTableModel();
		Object[] columnCafe = { "Nome da Espaço", "Lotação" };
		tableCafe.setModel(modelCafe);
		modelCafe.setColumnIdentifiers(columnCafe);

		JLabel lblNomeCafe = new JLabel("Nome");
		lblNomeCafe.setBounds(10, 36, 46, 14);
		panelCafe.add(lblNomeCafe);

		JLabel lblLotacaoCafe = new JLabel("Lota\u00E7\u00E3o");
		lblLotacaoCafe.setBounds(10, 61, 46, 14);
		panelCafe.add(lblLotacaoCafe);

		tFNomeCafe = new JTextField();
		tFNomeCafe.setBounds(79, 33, 193, 20);
		panelCafe.add(tFNomeCafe);
		tFNomeCafe.setColumns(10);

		tFLotacaoCafe = new JTextField();
		tFLotacaoCafe.setBounds(79, 58, 193, 20);
		panelCafe.add(tFLotacaoCafe);
		tFLotacaoCafe.setColumns(10);

		cadastrarHoraCafe();
		atualizarHoraCafe();
		deletarHoraCafe();
	}

	private void cadastrarHoraCafe() {
		JButton btnAdicionarCafe = new JButton("Adicionar");
		btnAdicionarCafe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tFNomeCafe.getText().equals("") || tFLotacaoCafe.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor, Informe um nome e lotação!");
				} else {
					try {
						IHoraCafe sala = new HoraCafe();
						sala.setSala(tFNomeCafe.getText());
						sala.setCapacidade(Integer.parseInt(tFLotacaoCafe.getText()));
						cadastrarHoraCafe.addSala(sala);
						
						modelCafe.addRow(new Object[] { sala.getSala(), sala.getCapacidade() });

						tFNomeCafe.setText("");
						tFLotacaoCafe.setText("");
						JOptionPane.showMessageDialog(null, "Cadastro salvo!");
					} catch (Exception execp) {
						JOptionPane.showMessageDialog(null, "A lotação da sala deve ser um numero!");
					}
				}
			}
		});
		btnAdicionarCafe.setBounds(0, 115, 89, 23);
		panelCafe.add(btnAdicionarCafe);
	}

	private void atualizarHoraCafe() {
		JButton btnAtualizarCafe = new JButton("Atualizar");
		btnAtualizarCafe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tableCafe.getSelectedRow();
				if (i >= 0) {
					try {
						IHoraCafe sala = new HoraCafe();
						sala.setSala(tableCafe.getModel().getValueAt(i, 0).toString());
						sala.setCapacidade(Integer.parseInt(tableCafe.getModel().getValueAt(i, 1).toString()));
						cadastrarHoraCafe.atualizarSala(sala, tFNomeCafe.getText(),
								Integer.parseInt(tFLotacaoSala.getText()));

						modelCafe.setValueAt(tFNomeCafe.getText(), i, 0);
						modelCafe.setValueAt(tFLotacaoCafe.getText(), i, 1);
						tFNomeCafe.setText("");
						tFLotacaoCafe.setText("");
						JOptionPane.showMessageDialog(null, "Cadastro atualizado!");
					} catch (Exception excp) {
						JOptionPane.showMessageDialog(null, "A lotação da sala deve ser um numero!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Por favor, selecione um espaço de café!");
				}
			}
		});
		btnAtualizarCafe.setBounds(0, 147, 89, 23);
		panelCafe.add(btnAtualizarCafe);
	}

	private void deletarHoraCafe() {
		JButton btnDeletarCafe = new JButton("Deletar");
		btnDeletarCafe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = tableCafe.getSelectedRow();
				if (i >= 0) {
					IHoraCafe sala = new HoraCafe();
					sala.setSala(tableCafe.getModel().getValueAt(i, 0).toString());
					sala.setCapacidade(0);
					cadastrarHoraCafe.deletarSala(sala);

					modelCafe.removeRow(i);
					tFNomeCafe.setText("");
					tFLotacaoCafe.setText("");
					JOptionPane.showMessageDialog(null, "Deletado!");
				} else {
					JOptionPane.showMessageDialog(null, "Por favor, selecione uma espaço de café para deletar!");
				}
			}
		});
		btnDeletarCafe.setBounds(0, 182, 89, 23);
		panelCafe.add(btnDeletarCafe);
	}

}
