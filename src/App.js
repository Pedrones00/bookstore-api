import "bootstrap/dist/css/bootstrap.min.css";

// App.jsx
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

// Pages
import HomePage from "./pages/Home/HomePage";
import AuthorsPage from "./pages/Authors/AuthorsPage";
import AuthorForm from "./pages/Authors/AuthorForm";
import BooksPage from "./pages/Books/BooksPage";
import BookForm from "./pages/Books/BookForm";

function App() {
  return (
    <Router>
      <Routes>
        {/* Home */}
        <Route path="/" element={<HomePage />} />

        {/* Autores - CRUD */}
        <Route path="/authors" element={<AuthorsPage />} />
        <Route path="/authors/new" element={<AuthorForm />} />
        <Route path="/authors/edit/:id" element={<AuthorForm />} />

        {/* Livros - CRUD */}
        <Route path="/books" element={<BooksPage />} />
        <Route path="/books/new" element={<BookForm />} />
        <Route path="/books/edit/:id" element={<BookForm />} />
      </Routes>
    </Router>
  );
}

export default App;
