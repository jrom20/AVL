public class AVL
{
    Nodo Raiz;

    public AVL()
    {
        Raiz = null;
    }

    private Nodo Insertar(Nodo padre, int valor)
    {
        if(padre == null)
        {
            padre = new Nodo(valor);
        }
        else if(valor < padre.Valor)
        {
            padre.Izquierdo = Insertar(padre.Izquierdo, valor);
        }else if(valor > padre.Valor)
        {
            padre.Derecho = Insertar(padre.Derecho, valor);
        }

        padre = Balancear(padre);

        return padre;
    }

    public Nodo Agregar(int valor)
    {
        Raiz = Insertar(Raiz, valor);
        return Raiz;
    }

    private Nodo Balancear(Nodo padre)
    {
        if (padre != null)
        {
            int ladoIzquierdo = GetAltura(padre.Izquierdo);
            int ladoDerecho = GetAltura(padre.Derecho);

            int desbalance = ladoIzquierdo - ladoDerecho;
            EstadoArbol peso = EstadoArbol.Balanceado;

            if (desbalance == 2)
                peso = EstadoArbol.PesoAlLadoIzquierdo;
            if (desbalance == -2)
                peso = EstadoArbol.PesoAlLadoDerecho;

            if (peso == EstadoArbol.PesoAlLadoDerecho)
            {
                int ladoDerechoIzquierdo = GetAltura(padre.Derecho.Izquierdo);
                int ladoDerechoDerecho = GetAltura(padre.Derecho.Derecho);
                int desbalanceDerecho = ladoDerechoDerecho - ladoDerechoIzquierdo;

                if (padre.Derecho != null && desbalanceDerecho < 0)
                {
                    //DerechaIzquierda
                } else
                {
                    //Rotacion Izquierda
                }
            }
            else if (peso == EstadoArbol.PesoAlLadoIzquierdo)
            {
                int ladoDerechoIzquierdo = GetAltura(padre.Izquierdo.Izquierdo);
                int ladoDerechoDerecho = GetAltura(padre.Izquierdo.Derecho);
                int desbalanceIzquierdo = ladoDerechoDerecho - ladoDerechoIzquierdo;

                if (padre.Izquierdo != null && desbalanceIzquierdo > 0) {
                    //IzquierdaDerecha
                } else {
                    //Rotacion Derecha
                }
            }
        }

        return padre;
    }

    private Nodo RotacionDerecha(Nodo padre)
    {
        return null;
    }

    private int GetAltura(Nodo nodoActual)
    {
        if(nodoActual == null)
            return 0;

        int ladoDerecho = GetAltura(nodoActual.Derecho);
        int ladoIzquierdo = GetAltura(nodoActual.Izquierdo);

        if(ladoDerecho > ladoIzquierdo)
            return ladoDerecho + 1;
        else
            return ladoIzquierdo + 1;

    }
}
