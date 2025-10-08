import { Table, Button, Container } from "react-bootstrap";
import { Link } from "react-router-dom";
import { Header } from "../../components/Header";

export const BooksPage = () => {
  const books = [
    {
      id: 1,
      title: "Harry Potter e a Pedra Filosofal",
      isbn: "978-65-5532-025-1",
      published_year: "1997",
      price: "300.00",
      created_at: "31/12/2023",
      updated_at: "31/12/2024",
    },
  ];

  return (
    <>
      <Header></Header>

      <Container>
        <h2 className="mb-4">Livros</h2>

        <Table striped bordered hover responsive>
          <thead>
            <tr>
              <th>Título</th>
              <th>ISBN</th>
              <th>Ano de publicação</th>
              <th>Preço</th>
              <th>Data de cadastro</th>
              <th>Data da última atualização</th>
              <th>Ações</th>
            </tr>
          </thead>
          <tbody>
            {books.map((book) => (
              <tr key={book.id}>
                <td>{book.title}</td>
                <td>{book.isbn}</td>
                <td>{book.published_year}</td>
                <td>R$ {book.price}</td>
                <td>{book.created_at}</td>
                <td>{book.updated_at}</td>
                <td>
                  <Link to={"/books/edit"}>
                    <Button
                      title="Editar"
                      aria-label="Editar"
                      variant="outline-primary"
                      size="sm"
                      className="me-2"
                    >
                      <span className="material-symbols-outlined d-flex justify-content-center align-center">
                        edit
                      </span>
                    </Button>
                  </Link>
                  <Button
                    title="Excluir"
                    aria-label="Excluir"
                    variant="outline-danger"
                    size="sm"
                  >
                    <span className="material-symbols-outlined d-flex justify-content-center align-center">
                      delete
                    </span>
                  </Button>
                </td>
              </tr>
            ))}
          </tbody>
        </Table>

        <div className="d-flex justify-content-end mt-5">
          <Link to="/books/new">
            <Button variant="success" className="d-flex align-items-center">
              <span className="material-symbols-outlined me-2">add</span>
              <span>Novo Livro</span>
            </Button>
          </Link>
        </div>
      </Container>
    </>
  );
};

export default BooksPage;
