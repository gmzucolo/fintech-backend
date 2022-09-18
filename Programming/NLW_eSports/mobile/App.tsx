import { StatusBar } from 'react-native';
import { Background } from './src/components/Background';
import { Home } from './src/screens/Home';
import { Loading } from './src/components/Loading';


export default function App() {
  return (
    <Background>
      <StatusBar
      barStyle="light-content"
      backgroundColor="transparent"
      translucent />
      <Home>
        
      </Home>
    </Background>
  );
}
