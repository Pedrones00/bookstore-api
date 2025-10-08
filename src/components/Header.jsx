import { Container, Nav, Navbar, NavDropdown } from "react-bootstrap";

export const Header = () => {
  return (
    <Navbar
      expand="lg"
      bg="dark"
      variant="dark"
      data-bs-theme="dark"
      className="mb-5"
    >
      <Container>
        <Navbar.Brand href="/">Livraria</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link href="/">Home</Nav.Link>
            <NavDropdown title="Livros" id="basic-nav-dropdown">
              <NavDropdown.Item href="/books/new">Adicionar</NavDropdown.Item>
              <NavDropdown.Item href="/books">Visualizar</NavDropdown.Item>
              <NavDropdown.Item href="/books/edit/:id">Editar</NavDropdown.Item>
              <NavDropdown.Item href="/books/delete/:id">
                Remover
              </NavDropdown.Item>
            </NavDropdown>
            <NavDropdown title="Autores" id="basic-nav-dropdown">
              <NavDropdown.Item href="/authors/new">Adicionar</NavDropdown.Item>
              <NavDropdown.Item href="/authors">Visualizar</NavDropdown.Item>
              <NavDropdown.Item href="/authors/edit/:id">
                Editar
              </NavDropdown.Item>
              <NavDropdown.Item href="/authors/delete/:id">
                Remover
              </NavDropdown.Item>
            </NavDropdown>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};
