// pages/api/submit.js
export default async function handler(req, res) {
    if (req.method === 'POST') {
        try {
            const response = await fetch('http://localhost:8080/input/submit', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(req.body),
            });
            const result = await response.json();
            res.status(200).json(result);
        } catch (error) {
            console.error('Error connecting to backend:', error);
            res.status(500).json({ error: 'Error connecting to backend' });
        }
    } else {
        res.setHeader('Allow', ['POST']);
        res.status(405).end(`Method ${req.method} Not Allowed`);
    }
}