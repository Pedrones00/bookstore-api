// pages/Authors/AuthorsPage.jsx
import { Table, Button, Container } from "react-bootstrap";
import { Link } from "react-router-dom";
import { Header } from "../../components/Header";

const AuthorsPage = () => {
  const authors = [
    {
      id: 1,
      name: "Fulano",
      birth_date: "31/12/2000",
      nationality: "Brasileiro",
      created_at: "31/12/2023",
      updated_at: "31/12/2004",
    },
    {
      id: 2,
      name: "Fulano",
      birth_date: "31/12/2000",
      nationality: "Brasileiro",
      created_at: "31/12/2023",
      updated_at: "31/12/2004",
    },
  ];

  return (
    <>
      <Header></Header>

      <Container>
        <h2 className="mb-4">Autores</h2>

        <Table striped bordered hover responsive>
          <thead>
            <tr>
              <th>Nome</th>
              <th>Data de nascimento</th>
              <th>Nacionalidade</th>
              <th>Data de cadastro</th>
              <th>Data da última atualização</th>
              <th>Ações</th>
            </tr>
          </thead>
          <tbody>
            {authors.map((author) => (
              <tr key={author.id}>
                <td>{author.name}</td>
                <td>{author.birth_date}</td>
                <td>{author.nationality}</td>
                <td>{author.created_at}</td>
                <td>{author.updated_at}</td>
                <td>
                  <Link>
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
          <Link to="/authors/new">
            <Button variant="success" className="d-flex align-items-center">
              <span className="material-symbols-outlined me-2">add</span>
              <span>Novo Autor</span>
            </Button>
          </Link>
        </div>
      </Container>
    </>
  );
};

export default AuthorsPage;
