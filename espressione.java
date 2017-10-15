import java.util.Scanner;

public class espressione<E> {
	// private tree tree;
	// private class tree<E> {
	private Node<E> root;
	private int countInsertion;
	private class Node<E> {
		private double numero = Double.NaN;
		private String operatore = null;
		private Node<E> figlioSinistro;
		private Node<E> figlioDestro;
		private Node<E> padre;

		private Node(E value) {
			if (isOperator(value) == true) {
				this.operatore = (String) value;
			} else if (isNumber(value) == true) {
				this.numero = (double) value;
			}
		}

		public boolean isOperator(E value) {

			if (value.equals("+") || value.equals("-") || value.equals("/") || value.equals("*")) {
				return true;
			} else
				return false;
		}

		public boolean isNumber(E value) {
			if (isOperator(value) == false) {
				return true;
			} else
				return false;
		}

	}

	public boolean isOperator(E value) {

		if (value.equals("+") || value.equals("-") || value.equals("/") || value.equals("*")) {
			return true;
		} else
			return false;
	}

	public boolean isNumber(E value) {
		if (isOperator(value) == false) {
			return true;
		} else
			return false;
	}

	/*private Node<E> setPadre(Node<E> node) {

		if (node.figlioSinistro != null) {

			node.figlioSinistro.padre = node;

			setPadre(node.figlioSinistro);
		}
		if (node.figlioDestro != null) {

			node.figlioDestro.padre = node;

			setPadre(node.figlioDestro);
		}

		return node;
	}*/

	public boolean aggiungi(E value) {
		root = aggiungi(root, value);
		return true;

	}

	private Node<E> aggiungi(Node<E> node, E value) {
		countInsertion=0;
		if (node == null) {
			if (node == root) {
				if (isOperator(value) == true) {
					node = new Node<E>(value);
					countInsertion++;
				} else
					throw new IllegalArgumentException("Il primo elemento deve essere un operatore valido");
			} else {
				node = new Node<E>(value);
				countInsertion++;
			}
		} else {
			if (node.figlioSinistro == null) {
				node.figlioSinistro = aggiungi(node.figlioSinistro, value);
			} else {

				if (node.figlioSinistro.operatore != null) {
					aggiungi(node.figlioSinistro, value);
				} else if (node.figlioDestro == null) {
					node.figlioDestro = aggiungi(node.figlioDestro, value);
				} else if (node.figlioDestro != null) {
					if (node.figlioDestro.operatore != null) {
						aggiungi(node.figlioDestro, value);
					}
				}
				

				

			}
			if(countInsertion==0){
				if(node.figlioDestro==null){
				node.figlioDestro=aggiungi(node.figlioDestro, value);
				countInsertion++;
				}else if(node.figlioDestro.operatore!=null){
					aggiungi(node.figlioDestro, value);
				}
			}

		}

	//	setPadre(node);

		return node;

	}

	private boolean checkCompletezza(Node<E> node) {
		boolean correct = false;

		if (node.figlioSinistro != null && node.figlioDestro != null) {
			if (node.figlioSinistro.numero != Double.NaN && node.figlioDestro.numero != Double.NaN) {
				 correct = true;
			
		}/*else if(node.figlioDestro.operatore!=null){
			checkCompletezza(node.figlioDestro);
		}*/
			
		
		
	}else {
		correct = false;
	}
		return correct;
	}

	public void stampa() {
		stampa(root);
	}

	private void stampa(Node<E> node) {
		if (root == null) {
			System.out.println("Collezione vuota");
		} else if (node != null) {
			if (node.operatore != null) {
				System.out.print(node.operatore+" ");
			} else {
				System.out.print(node.numero+" ");
			}
			if (node.figlioSinistro != null) {
				stampa(node.figlioSinistro);
			}
			if (node.figlioDestro != null) {
				stampa(node.figlioDestro);
			}
		}

	}

	public double operazione() {
		return operazione(root);
	}

	private double operazione(Node<E> node) {
		double result = 0;
		if (node.figlioSinistro != null) {
			if (node.figlioSinistro.operatore != null) {
				operazione(node.figlioSinistro);
			}
		}
		if (node.figlioDestro != null) {
			if (node.figlioDestro.operatore != null) {
				operazione(node.figlioDestro);
			}
		}
		if (checkCompletezza(node) == true) {

			if (node.operatore.equals("+")) {
				node.numero = node.figlioSinistro.numero + node.figlioDestro.numero;
				node.operatore = null;
				result = node.numero;
			} else if (node.operatore.equals("-")) {
				node.numero = node.figlioSinistro.numero - node.figlioDestro.numero;
				node.operatore = null;
				result = node.numero;
			} else if (node.operatore.equals("*")) {
				node.numero = node.figlioSinistro.numero * node.figlioDestro.numero;
				node.operatore = null;
				result = node.numero;
			} else if (node.operatore.equals("/")) {
				node.numero = node.figlioSinistro.numero / node.figlioDestro.numero;
				node.operatore = null;
				result = node.numero;
			}
			node.figlioSinistro = null;
			node.figlioDestro = null;

			return result;
		}
		return result;
	}

	
	
}

// }
