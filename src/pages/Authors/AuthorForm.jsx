// pages/Authors/AuthorForm.jsx
import { Form, Button, Card, Container } from "react-bootstrap";
import { Header } from "../../components/Header";

const AuthorForm = () => {
  return (
    <>
      <Header></Header>
      <Container>
        <Card>
          <Card.Body>
            <h2 className="mb-4">Cadastrar Autor</h2>

            <Form className="d-grid gap-0 row-gap-3">
              <Form.Group>
                <Form.Label>Nome</Form.Label>
                <Form.Control type="text" name="name" required />
              </Form.Group>

              <Form.Group>
                <Form.Label>Data de nascimento</Form.Label>
                <Form.Control type="date" name="nationality" />
              </Form.Group>

              <Form.Group>
                <Form.Label>Nacionalidade</Form.Label>
                <Form.Select aria-label="Selecione a nacionalidade">
                  <option value="afegã(o)">afegã(o)</option>
                  <option value="sul-africano(a)">sul-africano(a)</option>
                  <option value="albanês(esa)">albanês(esa)</option>
                  <option value="alemã(ão)">alemã(ão)</option>
                  <option value="andorrano(a)">andorrano(a)</option>
                  <option value="angolano(a)">angolano(a)</option>
                  <option value="anguilano(a)">anguilano(a)</option>
                  <option value="antiguano(a)">antiguano(a)</option>
                  <option value="antilhano(a)">antilhano(a)</option>
                  <option value="árabe-saudita">árabe-saudita</option>
                  <option value="argelino(a)">argelino(a)</option>
                  <option value="argentino(a)">argentino(a)</option>
                  <option value="arménio(a)">arménio(a)</option>
                  <option value="arubano(a)">arubano(a)</option>
                  <option value="australiano(a)">australiano(a)</option>
                  <option value="austríaco(a)">austríaco(a)</option>
                  <option value="azeri">azeri</option>
                  <option value="baamiano(a)">baamiano(a)</option>
                  <option value="barenita">barenita</option>
                  <option value="bangladechiano(a)">bangladechiano(a)</option>
                  <option value="barbadense">barbadense</option>
                  <option value="belga">belga</option>
                  <option value="belizenho(a)">belizenho(a)</option>
                  <option value="beninese">beninese</option>
                  <option value="bermudense">bermudense</option>
                  <option value="bielorrusso(a)">bielorrusso(a)</option>
                  <option value="boliviano(a)">boliviano(a)</option>
                  <option value="bósnio(a)">bósnio(a)</option>
                  <option value="botsuano(a)">botsuano(a)</option>
                  <option value="brasileiro(a)">brasileiro(a)</option>
                  <option value="bruneíno(a)">bruneíno(a)</option>
                  <option value="búlgaro(a)">búlgaro(a)</option>
                  <option value="burquino(a)">burquino(a)</option>
                  <option value="burundiano(a)">burundiano(a)</option>
                  <option value="butanês(esa)">butanês(esa)</option>
                  <option value="cabo-verdiano(a)">cabo-verdiano(a)</option>
                  <option value="camaronês(esa)">camaronês(esa)</option>
                  <option value="cambojano(a)">cambojano(a)</option>
                  <option value="canadiano(a)">canadiano(a)</option>
                  <option value="cazaque">cazaque</option>
                  <option value="chadiano(a)">chadiano(a)</option>
                  <option value="chileno(a)">chileno(a)</option>
                  <option value="chinês(esa)">chinês(esa)</option>
                  <option value="cipriota">cipriota</option>
                  <option value="colombiano(a)">colombiano(a)</option>
                  <option value="comoriano(a)">comoriano(a)</option>
                  <option value="congolês(a)">congolês(a)</option>
                  <option value="norte-coreano(a)">norte-coreano(a)</option>
                  <option value="sul-coreano(a)">sul-coreano(a)</option>
                  <option value="marfinense">marfinense</option>
                  <option value="costarriquenho(a)">costarriquenho(a)</option>
                  <option value="croata">croata</option>
                  <option value="cubano(a)">cubano(a)</option>
                  <option value="curaçauense">curaçauense</option>
                  <option value="dinamarquês(esa)">dinamarquês(esa)</option>
                  <option value="jibutiano(a)">jibutiano(a)</option>
                  <option value="dominiquês(esa)">dominiquês(esa)</option>
                  <option value="egípcio(a)">egípcio(a)</option>
                  <option value="salvadorenho(a)">salvadorenho(a)</option>
                  <option value="emiradense">emiradense</option>
                  <option value="equatoriano(a)">equatoriano(a)</option>
                  <option value="eritreu(ia)">eritreu(ia)</option>
                  <option value="escocês(esa)">escocês(esa)</option>
                  <option value="eslovaco(a)">eslovaco(a)</option>
                  <option value="esloveno(a)">esloveno(a)</option>
                  <option value="espanhol(a)">espanhol(a)</option>
                  <option value="micronésio(a)">micronésio(a)</option>
                  <option value="norte-americano(a)">norte-americano(a)</option>
                  <option value="estoniano(a)">estoniano(a)</option>
                  <option value="etíope">etíope</option>
                  <option value="fijiano(a)">fijiano(a)</option>
                  <option value="filipino(a)">filipino(a)</option>
                  <option value="finlandês(esa)">finlandês(esa)</option>
                  <option value="francês(esa)">francês(esa)</option>
                  <option value="gabonês(a)">gabonês(a)</option>
                  <option value="gambiano(a)">gambiano(a)</option>
                  <option value="ganês(a)">ganês(a)</option>
                  <option value="georgiano(a)">georgiano(a)</option>
                  <option value="granadino(a)">granadino(a)</option>
                  <option value="grego(a)">grego(a)</option>
                  <option value="guadalupense">guadalupense</option>
                  <option value="guamês(a)">guamês(a)</option>
                  <option value="guatemalteco(a)">guatemalteco(a)</option>
                  <option value="guianês(esa)">guianês(esa)</option>
                  <option value="guianense">guianense</option>
                  <option value="guineano(a)">guineano(a)</option>
                  <option value="guinéu-equatoriano(a)">
                    guinéu-equatoriano(a)
                  </option>
                  <option value="guineense">guineense</option>
                  <option value="haitiano(a)">haitiano(a)</option>
                  <option value="hondurenho(a)">hondurenho(a)</option>
                  <option value="honconguês(esa)">honconguês(esa)</option>
                  <option value="húngaro(a)">húngaro(a)</option>
                  <option value="iemenita">iemenita</option>
                  <option value="caimanês(a)">caimanês(a)</option>
                  <option value="cookense">cookense</option>
                  <option value="faroense">faroense</option>
                  <option value="salomonense">salomonense</option>
                  <option value="virginense">virginense</option>
                  <option value="virginense">virginense</option>
                  <option value="indiano(a)">indiano(a)</option>
                  <option value="indonésia(o)">indonésia(o)</option>
                  <option value="inglês(esa)">inglês(esa)</option>
                  <option value="iraniano(a)">iraniano(a)</option>
                  <option value="iraquiano(a)">iraquiano(a)</option>
                  <option value="irlandês(a)">irlandês(a)</option>
                  <option value="norte-irlandês(esa)">
                    norte-irlandês(esa)
                  </option>
                  <option value="islandês(esa)">islandês(esa)</option>
                  <option value="israelense">israelense</option>
                  <option value="italiano(a)">italiano(a)</option>
                  <option value="jamaicano(a)">jamaicano(a)</option>
                  <option value="japonês(esa)">japonês(esa)</option>
                  <option value="jordano(a)">jordano(a)</option>
                  <option value="quiribatiano(a)">quiribatiano(a)</option>
                  <option value="kosovar">kosovar</option>
                  <option value="kuwaitiano(a)">kuwaitiano(a)</option>
                  <option value="laociano(a)">laociano(a)</option>
                  <option value="lesotiano(a)">lesotiano(a)</option>
                  <option value="letã(o)">letã(o)</option>
                  <option value="libanês(a)">libanês(a)</option>
                  <option value="liberiano(a)">liberiano(a)</option>
                  <option value="líbio(a)">líbio(a)</option>
                  <option value="listenstainiano(a)">listenstainiano(a)</option>
                  <option value="lituano(a)">lituano(a)</option>
                  <option value="luxemburguês(a)">luxemburguês(a)</option>
                  <option value="macaense">macaense</option>
                  <option value="macedônico(a)">macedônico(a)</option>
                  <option value="malgaxe">malgaxe</option>
                  <option value="malaio(a)">malaio(a)</option>
                  <option value="malauiano(a)">malauiano(a)</option>
                  <option value="maldivo(a)">maldivo(a)</option>
                  <option value="malinês">malinês</option>
                  <option value="maltês(a)">maltês(a)</option>
                  <option value="marroquino(a)">marroquino(a)</option>
                  <option value="martinicano(a)">martinicano(a)</option>
                  <option value="mauriciano(a)">mauriciano(a)</option>
                  <option value="mauritano(a)">mauritano(a)</option>
                  <option value="mexicano(a)">mexicano(a)</option>
                  <option value="birmanês(a)">birmanês(a)</option>
                  <option value="moçambicano(a)">moçambicano(a)</option>
                  <option value="moldavo(a)">moldavo(a)</option>
                  <option value="monegasco(a)">monegasco(a)</option>
                  <option value="mongol">mongol</option>
                  <option value="montenegrino(a)">montenegrino(a)</option>
                  <option value="monserratense">monserratense</option>
                  <option value="namibiano(a)">namibiano(a)</option>
                  <option value="nauruano(a)">nauruano(a)</option>
                  <option value="nepalês(a)">nepalês(a)</option>
                  <option value="nicaraguense">nicaraguense</option>
                  <option value="nigerino(a)">nigerino(a)</option>
                  <option value="nigeriano(a)">nigeriano(a)</option>
                  <option value="norueguês(esa)">norueguês(esa)</option>
                  <option value="neocaledónio(a)">neocaledónio(a)</option>
                  <option value="neozelandês(esa)">neozelandês(esa)</option>
                  <option value="omanense">omanense</option>
                  <option value="galês(esa)">galês(esa)</option>
                  <option value="neerlandês(a)">neerlandês(a)</option>
                  <option value="palauano(a)">palauano(a)</option>
                  <option value="palestiniano(a)">palestiniano(a)</option>
                  <option value="panamenho(a)">panamenho(a)</option>
                  <option value="papua">papua</option>
                  <option value="paquistanês(a)">paquistanês(a)</option>
                  <option value="paraguaio(a)">paraguaio(a)</option>
                  <option value="peruano(a)">peruano(a)</option>
                  <option value="polinésio(a)">polinésio(a)</option>
                  <option value="polonês(esa)">polonês(esa)</option>
                  <option value="porto-riquenho(a)">porto-riquenho(a)</option>
                  <option value="português(esa)">português(esa)</option>
                  <option value="catariano(a)">catariano(a)</option>
                  <option value="queniano(a)">queniano(a)</option>
                  <option value="quirguiz">quirguiz</option>
                  <option value="britânico(a)">britânico(a)</option>
                  <option value="centro-africano(a)">centro-africano(a)</option>
                  <option value="tcheco(a)">tcheco(a)</option>
                  <option value="taiwanês(a)">taiwanês(a)</option>
                  <option value="congolês(a)">congolês(a)</option>
                  <option value="dominicano(a)">dominicano(a)</option>
                  <option value="romeno(a)">romeno(a)</option>
                  <option value="ruandês(a)">ruandês(a)</option>
                  <option value="russo(a)">russo(a)</option>
                  <option value="são-martinhense">são-martinhense</option>
                  <option value="samoano(a)">samoano(a)</option>
                  <option value="samoense">samoense</option>
                  <option value="santa-luciense">santa-luciense</option>
                  <option value="são-cristovense">são-cristovense</option>
                  <option value="são-marinhense">são-marinhense</option>
                  <option value="são-tomense">são-tomense</option>
                  <option value="são-vicentino(a)">são-vicentino(a)</option>
                  <option value="senegalês(esa)">senegalês(esa)</option>
                  <option value="serra-leonês(a)">serra-leonês(a)</option>
                  <option value="sérvio(a)">sérvio(a)</option>
                  <option value="seichelense">seichelense</option>
                  <option value="singapurense">singapurense</option>
                  <option value="são-martinhense">são-martinhense</option>
                  <option value="sírio(a)">sírio(a)</option>
                  <option value="somali">somali</option>
                  <option value="cingalês(a)">cingalês(a)</option>
                  <option value="essuatiniano(a)">essuatiniano(a)</option>
                  <option value="sudanês(a)">sudanês(a)</option>
                  <option value="sueco(a)">sueco(a)</option>
                  <option value="suíço(a)">suíço(a)</option>
                  <option value="surinamês(a)">surinamês(a)</option>
                  <option value="tajique">tajique</option>
                  <option value="tailandês(esa)">tailandês(esa)</option>
                  <option value="taiwanês(a)">taiwanês(a)</option>
                  <option value="tanzaniano(a)">tanzaniano(a)</option>
                  <option value="timorense">timorense</option>
                  <option value="togolês(a)">togolês(a)</option>
                  <option value="tonganês(esa)">tonganês(esa)</option>
                  <option value="trinitário(a)-tobagense">
                    trinitário(a)-tobagense
                  </option>
                  <option value="tunisiano(a)">tunisiano(a)</option>
                  <option value="turquense">turquense</option>
                  <option value="turquemeno(a)">turquemeno(a)</option>
                  <option value="turco(a)">turco(a)</option>
                  <option value="tuvaluano(a)">tuvaluano(a)</option>
                  <option value="ucraniano(a)">ucraniano(a)</option>
                  <option value="ugandense">ugandense</option>
                  <option value="uruguaio(a)">uruguaio(a)</option>
                  <option value="usbeque">usbeque</option>
                  <option value="vanuatuense">vanuatuense</option>
                  <option value="vaticano(a)">vaticano(a)</option>
                  <option value="venezuelano(a)">venezuelano(a)</option>
                  <option value="vietnamita">vietnamita</option>
                  <option value="zambiano(a)">zambiano(a)</option>
                  <option value="zimbabuano(a)">zimbabuano(a)</option>
                </Form.Select>
              </Form.Group>

              <div className="d-flex gap-2 mt-4 justify-content-end">
                <Button variant="primary" type="submit">
                  Salvar
                </Button>

                <Button
                  variant="secondary"
                  onClick={() => window.history.back()}
                >
                  Cancelar
                </Button>
              </div>
            </Form>
          </Card.Body>
        </Card>
      </Container>
    </>
  );
};

export default AuthorForm;
