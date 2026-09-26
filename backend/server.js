require("dotenv").config({
    path: require("path").join(__dirname, ".env"),
    override: true
});

const express = require("express");
const { createGeminiClient } = require("./ai");

const app = express();
const PORT = process.env.PORT || 3000;

app.use(express.json());

app.get("/health", (req, res) => {
    res.json({
        status: "ok",
        service: "SecureQuest AI Backend - Gemini"
    });
});

app.post("/api/ask", async (req, res) => {
    try {
        const { question } = req.body;

        if (!question || typeof question !== "string" || !question.trim()) {
            return res.status(400).json({
                error: "A question is required."
            });
        }

        console.log("Question received:", question);

        const client = createGeminiClient();

        const response = await client.models.generateContent({
            model: "gemini-3.1-flash-lite",
            contents: question.trim()
        });

        console.log("Gemini request successful.");

        return res.json({
            status: "success",
            answer: response.text
        });

    } catch (error) {
        console.error("GEMINI ERROR:", error);

        return res.status(500).json({
            error: "Unable to generate an AI response.",
            details: error?.message || String(error)
        });
    }
});

const server = app.listen(PORT, "0.0.0.0", () => {
    console.log("");
    console.log("====================================");
    console.log("SecureQuest AI Backend - Gemini");
    console.log(`Server running on http://127.0.0.1:${PORT}`);
    console.log("====================================");
    console.log("KEEP THIS WINDOW OPEN.");
    console.log("");
});

server.on("error", (error) => {
    console.error("SERVER ERROR:", error);
});
