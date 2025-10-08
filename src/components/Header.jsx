import { Container, Nav, Navbar } from "react-bootstrap";

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
            <Nav.Link href="/books">Livros</Nav.Link>
            <Nav.Link href="/authors">Autores</Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};
